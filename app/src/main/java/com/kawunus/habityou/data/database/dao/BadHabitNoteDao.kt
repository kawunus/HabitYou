package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kawunus.habityou.data.database.entity.BadHabitNoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BadHabitNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: BadHabitNoteEntity)

    @Delete
    suspend fun delete(note: BadHabitNoteEntity)

    @Query("SELECT * FROM bad_habit_notes WHERE id = :habitId")
    fun getNotesByHabitId(habitId: Int): Flow<List<BadHabitNoteEntity?>>

    @Query("SELECT * FROM bad_habit_notes")
    fun getAllNotes(): Flow<List<BadHabitNoteEntity?>>

    @Update
    suspend fun update(note: BadHabitNoteEntity)
}