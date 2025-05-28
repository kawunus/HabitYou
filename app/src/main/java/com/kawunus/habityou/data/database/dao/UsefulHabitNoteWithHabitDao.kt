package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.kawunus.habityou.data.database.entity.UsefulHabitNoteWithHabitsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsefulHabitNoteWithHabitDao {

    @Transaction
    @Query("SELECT * FROM useful_habit_notes")
    fun getAllUsefulHabitsWithEntries(): Flow<List<UsefulHabitNoteWithHabitsEntity>>
}