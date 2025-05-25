package com.kawunus.habityou.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.kawunus.habityou.core.database.entity.UsefulHabitWithEntries

@Dao
interface UsefulHabitWithEntriesDao {

    @Transaction
    @Query("SELECT * FROM useful_habits")
    suspend fun getAllUsefulHabitsWithEntries(): List<UsefulHabitWithEntries>

}