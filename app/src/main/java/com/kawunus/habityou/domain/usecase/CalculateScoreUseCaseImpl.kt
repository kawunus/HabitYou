package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.usecase.CalculateScoreUseCase
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.usecase.CalculateScoreUseCaseImpl.Companion.ALPHA
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Clock
import java.time.LocalDate

/**
 * Implementation of [CalculateScoreUseCase] that calculates a smoothed habit score
 * using single exponential smoothing over completed habit entries.
 *
 * The score is computed by simulating a day-by-day iteration from the earliest logged entry
 * up to today, applying smoothing based on whether the habit was completed each day.
 *
 * Key features:
 * - Ignores future entries (only considers dates up to today).
 * - Uses [ALPHA] as the smoothing factor for exponential smoothing.
 * - The score increases when the habit is completed, and decays slowly over missed days.
 *
 * Example logic:
 * ```
 * Score_today = ALPHA * current_value + (1 - ALPHA) * Score_yesterday
 * ```
 * Where `current_value` is 1 if the habit was completed on that day, otherwise 0.
 *
 * @property getEntries The use case that provides all entries for a given habit.
 * @property clock The clock instance used to determine the current date (for testability).
 */
class CalculateScoreUseCaseImpl(
    private val getEntries: GetEntriesUseCase,
    private val clock: Clock
) : CalculateScoreUseCase {

    /**
     * Calculates the habit score for the given habit using exponential smoothing.
     *
     * The score reflects long-term consistency. It increases when the habit is completed
     * and gradually decays on days the habit is missed (except today).
     *
     * @param habitId The unique identifier of the habit.
     * @return A [Flow] emitting a [Float] score between 0 and 1, or `null` if there are no valid entries.
     */
    override fun invoke(habitId: Int): Flow<Float?> {
        return getEntries(habitId).map { list ->
            if (list.isEmpty()) return@map null

            val today = LocalDate.now(clock)
            val entries = list
                .filter { !it.date.isAfter(today) }
                .sortedByDescending { it.date }

            if (entries.isEmpty()) return@map null

            val entryDates = entries.map { it.date }.toSet()
            var date = entries.last().date
            var previous = 0f

            while (!date.isAfter(today)) {
                if (entryDates.contains(date)) {
                    previous = singleExponentialSmoothing(1f, previous)
                } else if (date != today) {
                    previous = singleExponentialSmoothing(0f, previous)
                }
                date = date.plusDays(1)
            }
            return@map previous

        }
    }

    /**
     * Applies single exponential smoothing to the current value.
     *
     * @param current The current day's value: 1.0 if completed, 0.0 if missed.
     * @param previous The previously smoothed score.
     * @return A new smoothed value.
     */
    private fun singleExponentialSmoothing(
        current: Float,
        previous: Float
    ): Float {
        return (ALPHA * current) + ((1 - ALPHA) * previous)
    }

    /**
     * The smoothing factor for exponential smoothing.
     * Must be in the range (0, 1). Smaller values give more weight to past values.
     */
    companion object {
        const val ALPHA = 0.05f
    }
}