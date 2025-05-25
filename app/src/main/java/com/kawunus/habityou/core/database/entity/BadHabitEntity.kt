package com.kawunus.habityou.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bad_habits")
data class BadHabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "last_occurrence") val lastOccurrence: Long,
    @ColumnInfo(name = "max_clean_streak") val maxCleanStreak: Long,
    @ColumnInfo(name = "quit_date") val quitDate: Long
)