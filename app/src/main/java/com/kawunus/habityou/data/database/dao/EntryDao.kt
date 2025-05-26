package com.kawunus.habityou.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.kawunus.habityou.data.database.entity.EntryEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface EntryDao {

    @Query("SELECT * FROM entries ORDER BY date DESC")
    fun getAllEntries(): Flow<List<EntryEntity>>

    @Query("SELECT * FROM entries WHERE id = :habitId ORDER BY date DESC")
    fun getAllEntriesById(habitId: Int): Flow<List<EntryEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insertEntry(entry: EntryEntity)

    @Delete
    suspend fun deleteEntry(entryId: EntryEntity)

    @Query("SELECT * FROM entries WHERE date = :date AND useful_habit_id = :habitId")
    suspend fun getEntryForDate(habitId: Int, date: LocalDate): EntryEntity?

}