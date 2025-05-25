package com.kawunus.habityou.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "entries", foreignKeys = [ForeignKey(
        entity = UsefulHabitEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("useful_habit_id"),
        onDelete = ForeignKey.CASCADE,
    )]
)
data class EntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "useful_habit_id", index = true)
    val habitId: Int,
    @ColumnInfo(name = "date", index = true)
    val date: LocalDate,
)