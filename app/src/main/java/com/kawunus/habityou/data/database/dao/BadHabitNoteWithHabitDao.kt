package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.kawunus.habityou.data.database.entity.BadHabitNoteWithHabitsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BadHabitNoteWithHabitDao {

    @Transaction
    @Query("SELECT * FROM bad_habits")
    fun getAllBadHabitsWithNotes(): Flow<List<BadHabitNoteWithHabitsEntity>>
}