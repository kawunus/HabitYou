package com.kawunus.habityou.domain.api.repository

import com.kawunus.habityou.data.dto.UsefulHabitDto
import kotlinx.coroutines.flow.Flow

interface UsefulHabitRepository {

    fun getAllUsefulHabits(): Flow<List<UsefulHabitDto>>

    fun getUsefulHabitById(id: Int): Flow<UsefulHabitDto?>

    suspend fun insertUsefulHabit(habit: UsefulHabitDto)

    suspend fun deleteUsefulHabit(habit: UsefulHabitDto)

    suspend fun updateUsefulHabit(habit: UsefulHabitDto)
}