package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kawunus.habityou.data.database.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY date DESC")
    suspend fun getAllNotes(): List<NoteEntity>

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)
}