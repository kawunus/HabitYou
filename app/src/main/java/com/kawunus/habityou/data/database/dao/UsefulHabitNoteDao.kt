package com.kawunus.habityou.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kawunus.habityou.data.database.entity.UsefulHabitNoteEntity
import kotlinx.coroutines.flow.Flow

interface UsefulHabitNoteDao {

    @Insert
    suspend fun insert(note: UsefulHabitNoteEntity)

    @Delete
    suspend fun delete(note: UsefulHabitNoteEntity)

    @Query("SELECT * FROM useful_habit_notes WHERE id = :habitId")
    fun getNotesByHabitId(habitId: Int): Flow<List<UsefulHabitNoteEntity?>>

    @Query("SELECT * FROM useful_habit_notes")
    fun getAllNotes(): Flow<List<UsefulHabitNoteEntity?>>

    @Update
    suspend fun update(note: UsefulHabitNoteEntity)
}