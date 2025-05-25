package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.EntryDao
import com.kawunus.habityou.data.dto.EntryDto
import com.kawunus.habityou.domain.api.EntryRepository
import com.kawunus.habityou.utils.mappers.toEntryDto
import com.kawunus.habityou.utils.mappers.toEntryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EntryRepositoryImpl(private val entryDao: EntryDao) : EntryRepository {
    override suspend fun insertEntry(entry: EntryDto) {
        entryDao.insertEntry(entry.toEntryEntity())
    }

    override suspend fun deleteEntry(entry: EntryDto) {
        entryDao.deleteEntry(entry.toEntryEntity())
    }

    override suspend fun getEntriesByHabitId(habitId: Int): Flow<List<EntryDto>> = flow {
        emit(entryDao.getAllEntriesById(habitId).map { it.toEntryDto() })
    }

    override suspend fun getAllEntries(): Flow<List<EntryDto>> = flow {
        emit(entryDao.getAllEntries().map { it.toEntryDto() })
    }
}