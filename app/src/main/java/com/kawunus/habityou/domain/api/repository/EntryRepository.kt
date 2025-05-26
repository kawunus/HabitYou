package com.kawunus.habityou.domain.api.repository

import com.kawunus.habityou.data.dto.EntryDto
import kotlinx.coroutines.flow.Flow

interface EntryRepository {

    suspend fun toggleEntry(entry: EntryDto)

    suspend fun deleteEntry(entry: EntryDto)

    fun getEntriesByHabitId(habitId: Int): Flow<List<EntryDto>>

    fun getAllEntries(): Flow<List<EntryDto>>
}