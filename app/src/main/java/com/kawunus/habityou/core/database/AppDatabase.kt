package com.kawunus.habityou.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawunus.habityou.core.database.dao.BadHabitDao
import com.kawunus.habityou.core.database.dao.NoteDao
import com.kawunus.habityou.core.database.entity.BadHabitEntity
import com.kawunus.habityou.core.database.entity.NoteEntity

@Database(
    version = 1, entities = [BadHabitEntity::class, NoteEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao

    abstract fun noteDao(): NoteDao
}