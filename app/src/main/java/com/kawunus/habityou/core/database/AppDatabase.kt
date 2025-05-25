package com.kawunus.habityou.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kawunus.habityou.core.database.dao.BadHabitDao
import com.kawunus.habityou.core.database.dao.EntryDao
import com.kawunus.habityou.core.database.dao.NoteDao
import com.kawunus.habityou.core.database.dao.UsefulHabitDao
import com.kawunus.habityou.core.database.dao.UsefulHabitWithEntriesDao
import com.kawunus.habityou.core.database.entity.BadHabitEntity
import com.kawunus.habityou.core.database.entity.EntryEntity
import com.kawunus.habityou.core.database.entity.NoteEntity
import com.kawunus.habityou.core.database.entity.UsefulHabitEntity
import com.kawunus.habityou.core.database.entity.UsefulHabitWithEntries
import com.kawunus.habityou.utils.converters.DatabaseConverter

@Database(
    version = 1,
    entities = [BadHabitEntity::class, NoteEntity::class, UsefulHabitEntity::class, UsefulHabitWithEntries::class, EntryEntity::class]
)
@TypeConverters(DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao

    abstract fun noteDao(): NoteDao

    abstract fun usefulHabitDao(): UsefulHabitDao

    abstract fun usefulHabitWithEntriesDao(): UsefulHabitWithEntriesDao

    abstract fun entryDao(): EntryDao

}