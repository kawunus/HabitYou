package com.kawunus.habityou.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kawunus.habityou.data.database.dao.BadHabitDao
import com.kawunus.habityou.data.database.dao.EntryDao
import com.kawunus.habityou.data.database.dao.NoteDao
import com.kawunus.habityou.data.database.dao.UsefulHabitDao
import com.kawunus.habityou.data.database.dao.UsefulHabitWithEntriesDao
import com.kawunus.habityou.data.database.entity.BadHabitEntity
import com.kawunus.habityou.data.database.entity.EntryEntity
import com.kawunus.habityou.data.database.entity.NoteEntity
import com.kawunus.habityou.data.database.entity.UsefulHabitEntity
import com.kawunus.habityou.utils.converters.DatabaseConverter

@Database(
    version = 1,
    entities = [BadHabitEntity::class, NoteEntity::class, UsefulHabitEntity::class, EntryEntity::class]
)
@TypeConverters(DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao

    abstract fun noteDao(): NoteDao

    abstract fun usefulHabitDao(): UsefulHabitDao

    abstract fun usefulHabitWithEntriesDao(): UsefulHabitWithEntriesDao

    abstract fun entryDao(): EntryDao

}