package com.kawunus.habitu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawunus.habitu.data.db.dao.BadHabitDao
import com.kawunus.habitu.data.db.dao.NoteDao
import com.kawunus.habitu.data.db.entity.BadHabitEntity
import com.kawunus.habitu.data.db.entity.NoteEntity

@Database(
    version = 1, entities = [BadHabitEntity::class, NoteEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao

    abstract fun noteDao(): NoteDao
}