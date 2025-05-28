package com.kawunus.habityou.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "useful_habit_notes")
data class UsefulHabitNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
)