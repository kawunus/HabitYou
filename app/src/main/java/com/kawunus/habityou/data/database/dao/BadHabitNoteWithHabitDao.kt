package com.kawunus.habityou.data.database.dao

import androidx.room.Query
import androidx.room.Transaction
import com.kawunus.habityou.data.database.entity.BadHabitNoteWithHabitsEntity
import kotlinx.coroutines.flow.Flow

interface BadHabitNoteWithHabitDao {

    @Transaction
    @Query("SELECT * FROM bad_habit_notes")
    fun getAllUsefulHabitsWithEntries(): Flow<List<BadHabitNoteWithHabitsEntity>>
}