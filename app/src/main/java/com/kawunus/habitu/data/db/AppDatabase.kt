package com.kawunus.habitu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawunus.habitu.data.db.dao.BadHabitDao
import com.kawunus.habitu.data.db.entity.BadHabitEntity

@Database(
    version = 1, entities = [BadHabitEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun badHabitDao(): BadHabitDao
}