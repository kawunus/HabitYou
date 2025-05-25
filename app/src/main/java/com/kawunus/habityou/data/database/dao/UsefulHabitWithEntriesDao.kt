package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.kawunus.habityou.data.database.entity.UsefulHabitWithEntriesEntity

@Dao
interface UsefulHabitWithEntriesDao {

    @Transaction
    @Query("SELECT * FROM useful_habits")
    suspend fun getAllUsefulHabitsWithEntries(): List<UsefulHabitWithEntriesEntity>

}