package com.kawunus.habityou.domain.api.repository

import com.kawunus.habityou.data.dto.EntryDto
import kotlinx.coroutines.flow.Flow

interface EntryRepository {

    suspend fun insertEntry(entry: EntryDto)

    suspend fun deleteEntry(entry: EntryDto)

    suspend fun getEntriesByHabitId(habitId: Int): Flow<List<EntryDto>>

    suspend fun getAllEntries(): Flow<List<EntryDto>>
}