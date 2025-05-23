package com.kawunus.habitu.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bad_habits")
data class BadHabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    @ColumnInfo(name = "habit_name")
    val habitName: String,
    @ColumnInfo(name = "last_occurrence")
    val lastOccurrence: Long?
)