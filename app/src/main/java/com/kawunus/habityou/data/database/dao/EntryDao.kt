package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.kawunus.habityou.data.database.entity.EntryEntity

@Dao
interface EntryDao {

    @Query("SELECT * FROM entries ORDER BY date DESC")
    suspend fun getAllEntries(): List<EntryEntity>

    @Query("SELECT * FROM entries WHERE id = :habitId ORDER BY date DESC")
    suspend fun getAllEntriesById(habitId: Int): List<EntryEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertEntry(entry: EntryEntity)

    @Delete
    suspend fun deleteEntry(entryId: EntryEntity)


}