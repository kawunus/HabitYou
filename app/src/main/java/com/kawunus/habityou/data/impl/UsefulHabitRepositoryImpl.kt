package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.UsefulHabitDao
import com.kawunus.habityou.data.dto.UsefulHabitDto
import com.kawunus.habityou.domain.api.UsefulHabitsRepository
import com.kawunus.habityou.utils.mappers.toUsefulHabitDto
import com.kawunus.habityou.utils.mappers.toUsefulHabitEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsefulHabitRepositoryImpl(private val habitDao: UsefulHabitDao) : UsefulHabitsRepository {
    override suspend fun getAllUsefulHabits(): Flow<List<UsefulHabitDto>> = flow {
        emit(habitDao.getAllUsefulHabits().map { it.toUsefulHabitDto() })
    }

    override suspend fun getUsefulHabitById(id: Int): Flow<UsefulHabitDto?> = flow {
        emit(habitDao.getUsefulHabitById(id)?.toUsefulHabitDto())
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