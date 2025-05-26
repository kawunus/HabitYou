package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kawunus.habityou.data.database.entity.UsefulHabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsefulHabitDao {

    @Query("SELECT * FROM useful_habits")
    fun getAllUsefulHabits(): Flow<List<UsefulHabitEntity>>

    @Query("SELECT * FROM useful_habits WHERE id = :id")
    fun getUsefulHabitById(id: Int): Flow<UsefulHabitEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsefulHabit(habit: UsefulHabitEntity)

    @Delete
    suspend fun deleteUsefulHabit(habit: UsefulHabitEntity)

    @Update
    suspend fun updateUsefulHabit(habit: UsefulHabitEntity)
}