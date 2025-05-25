package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.EntryRepository
import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.model.Entry
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import com.kawunus.habityou.utils.mappers.toEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetEntriesUseCaseImpl(
    private val usefulHabitRepository: UsefulHabitRepository,
    private val entryRepository: EntryRepository
) : GetEntriesUseCase {
    override suspend fun invoke(habitId: Int): Flow<List<Entry>> {
        return combine(
            usefulHabitRepository.getUsefulHabitById(habitId),
            entryRepository.getEntriesByHabitId(habitId)
        ) { habit, entries ->

            if (entries.isEmpty() || habit == null)
                return@combine listOf<Entry>()

            when (habit.frequency) {
                UsefulHabitFrequency.DAILY -> {
                    return@combine entries.map { it.toEntry() }
                }
            }
        }
    }
}