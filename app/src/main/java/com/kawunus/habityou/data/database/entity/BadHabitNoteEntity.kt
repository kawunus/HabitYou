package com.kawunus.habityou.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "bad_habit_notes", foreignKeys = [ForeignKey(
        entity = BadHabitEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("bad_habit_id"),
        onDelete = ForeignKey.CASCADE,
    )]
)
data class BadHabitNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
    @ColumnInfo(name = "bad_habit_id")
    val badHabitId: Int
)