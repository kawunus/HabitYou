package com.kawunus.habitu.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kawunus.habitu.data.db.entity.BadHabitEntity

@Dao
interface BadHabitDao {

    @Insert
    suspend fun insertHabit(habit: BadHabitEntity)

    @Delete
    suspend fun deleteHabit(habit: BadHabitEntity)

    @Query("SELECT * FROM bad_habits")
    suspend fun getAllHabits(): List<BadHabitEntity>

    @Update
    suspend fun updateHabit(entity: BadHabitEntity)
}