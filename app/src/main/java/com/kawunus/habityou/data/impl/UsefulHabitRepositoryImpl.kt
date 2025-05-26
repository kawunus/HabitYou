package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.UsefulHabitDao
import com.kawunus.habityou.data.dto.UsefulHabitDto
import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.utils.mappers.toUsefulHabitDto
import com.kawunus.habityou.utils.mappers.toUsefulHabitEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsefulHabitRepositoryImpl(private val habitDao: UsefulHabitDao) : UsefulHabitRepository {
    override fun getAllUsefulHabits(): Flow<List<UsefulHabitDto>> {
        return habitDao.getAllUsefulHabits().map { list ->
            list.map { it.toUsefulHabitDto() }
        }
    }

    override fun getUsefulHabitById(id: Int): Flow<UsefulHabitDto?> {
        return habitDao.getUsefulHabitById(id).map {
            it?.toUsefulHabitDto()
        }
    }

    override suspend fun insertUsefulHabit(habit: UsefulHabitDto) {
        habitDao.insertUsefulHabit(habit.toUsefulHabitEntity())
    }

    override suspend fun deleteUsefulHabit(habit: UsefulHabitDto) {
        habitDao.deleteUsefulHabit(habit.toUsefulHabitEntity())
    }

    override suspend fun updateUsefulHabit(habit: UsefulHabitDto) {
        habitDao.updateUsefulHabit(habit.toUsefulHabitEntity())
    }
}