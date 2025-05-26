package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.model.Streak
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Clock
import java.time.LocalDate

class CalculateStreaksUseCaseImpl(
    private val getEntries: GetEntriesUseCase,
    private val clock: Clock
) : CalculateStreaksUseCase {

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

