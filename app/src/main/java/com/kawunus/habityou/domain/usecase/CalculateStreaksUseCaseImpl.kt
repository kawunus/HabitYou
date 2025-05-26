package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.model.Streak
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Clock
import java.time.LocalDate

/**
 * Implementation of [CalculateStreaksUseCase] that calculates consecutive habit streaks
 * based on the dates of completed habit entries.
 *
 * A streak is defined as a sequence of at least two consecutive days with habit entries.
 * Single-day completions are ignored by default.
 *
 * This implementation:
 * - Filters out future dates (only includes entries up to and including today).
 * - Sorts the entries in ascending order (from oldest to newest).
 * - Groups entries into streaks of consecutive days.
 *
 * @property getEntries Use case to retrieve the list of habit entries for a given habit.
 * @property clock Clock used for getting the current date (supports testing and custom time).
 */
class CalculateStreaksUseCaseImpl(
    private val getEntries: GetEntriesUseCase,
    private val clock: Clock
) : CalculateStreaksUseCase {

    /**
     * Calculates all streaks of at least two consecutive days for the given habit.
     *
     * @param habitId The ID of the habit for which to calculate streaks.
     * @return A [Flow] emitting a list of [Streak] objects, each representing a sequence
     *         of consecutive completed days.
     *
     * Example:
     * ```
     * Input dates: [2025-05-21, 2025-05-22, 2025-05-24, 2025-05-25, 2025-05-26]
     * Output streaks:
     *   - Streak(length = 2, endDate = 2025-05-22)
     *   - Streak(length = 3, endDate = 2025-05-26)
     * ```
     */
    override fun invoke(habitId: Int): Flow<List<Streak>> {
        return getEntries(habitId).map { list ->
            if (list.isEmpty()) return@map emptyList()

            val today = LocalDate.now(clock)
            val entries = list
                .filter { !it.date.isAfter(today) }
                .sortedBy { it.date }

            val streaks = mutableListOf<Streak>()
            var streakLength = 1
            var streakStartDate = entries.first().date

            for (i in 1 until entries.size) {
                val current = entries[i].date
                val previous = entries[i - 1].date

                if (current == previous.plusDays(1)) {
                    streakLength++
                } else {
                    if (streakLength >= 2) {
                        streaks.add(
                            Streak(length = streakLength, endDate = previous)
                        )
                    }

                    streakLength = 1
                    streakStartDate = current
                }
            }

            val lastDate = entries.last().date
            if (streakLength >= 2) {
                streaks.add(Streak(length = streakLength, endDate = lastDate))
            }

            return@map streaks
        }
    }
}

