package com.kawunus.habityou.domain.api.repository

import com.kawunus.habityou.data.dto.UsefulHabitsWithEntriesDto
import kotlinx.coroutines.flow.Flow

interface UsefulHabitWithEntriesRepository {

    fun getAllHabitsWithEntries(): Flow<List<UsefulHabitsWithEntriesDto>>
}