package com.kawunus.habityou.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "useful_habit_notes", foreignKeys = [ForeignKey(
        entity = UsefulHabitEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("useful_habit_id"),
        onDelete = ForeignKey.CASCADE,
    )]
)
data class UsefulHabitNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
    @ColumnInfo(name = "useful_habit_id")
    val usefulHabitId: Int
)