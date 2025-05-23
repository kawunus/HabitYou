package com.kawunus.habitu.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawunus.habitu.core.database.dao.BadHabitDao
import com.kawunus.habitu.core.database.dao.NoteDao
import com.kawunus.habitu.core.database.entity.BadHabitEntity
import com.kawunus.habitu.core.database.entity.NoteEntity

@Database(
    version = 1, entities = [BadHabitEntity::class, NoteEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao

    abstract fun noteDao(): NoteDao
}