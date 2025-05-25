package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.UsefulHabitWithEntries
import kotlinx.coroutines.flow.Flow

interface GetUsefulHabitsWithEntriesUseCase {

    suspend operator fun invoke(): Flow<List<UsefulHabitWithEntries>>
}