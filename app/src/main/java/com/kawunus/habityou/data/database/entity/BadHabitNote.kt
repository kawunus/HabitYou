package com.kawunus.habityou.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bad_habit_note")
data class BadHabitNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
)