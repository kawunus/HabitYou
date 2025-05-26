package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.UsefulHabitWithEntriesDao
import com.kawunus.habityou.data.dto.UsefulHabitsWithEntriesDto
import com.kawunus.habityou.domain.api.repository.UsefulHabitWithEntriesRepository
import com.kawunus.habityou.utils.mappers.toUsefulHabitsWithEntriesDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsefulHabitWithEntriesRepositoryImpl(private val usefulHabitsWithEntriesDao: UsefulHabitWithEntriesDao) :
    UsefulHabitWithEntriesRepository {
    override fun getAllHabitsWithEntries(): Flow<List<UsefulHabitsWithEntriesDto>> {
        return usefulHabitsWithEntriesDao.getAllUsefulHabitsWithEntries().map { list ->
            list.map {
                it.toUsefulHabitsWithEntriesDto()
            }
        }
    }
}