package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.EntryDao
import com.kawunus.habityou.data.dto.EntryDto
import com.kawunus.habityou.domain.api.repository.EntryRepository
import com.kawunus.habityou.utils.mappers.toEntryDto
import com.kawunus.habityou.utils.mappers.toEntryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EntryRepositoryImpl(private val entryDao: EntryDao) : EntryRepository {
    override suspend fun toggleEntry(entry: EntryDto) {
        val currentEntity = entryDao.getEntryForDate(entry.habitId, entry.date)
        if (currentEntity == null) {
            entryDao.insertEntry(entry.toEntryEntity())
        } else {
            entryDao.deleteEntry(currentEntity)
        }
    }

    override suspend fun deleteEntry(entry: EntryDto) {
        entryDao.deleteEntry(entry.toEntryEntity())
    }

    override fun getEntriesByHabitId(habitId: Int): Flow<List<EntryDto>> {
        return entryDao.getAllEntriesById(habitId).map { list ->
            list.map {
                it.toEntryDto()
            }
        }
    }

    override fun getAllEntries(): Flow<List<EntryDto>> {
        return entryDao.getAllEntries().map { list ->
            list.map {
                it.toEntryDto()
            }
        }
    }
}