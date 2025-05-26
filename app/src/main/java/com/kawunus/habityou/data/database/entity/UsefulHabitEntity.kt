package com.kawunus.habityou.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kawunus.habityou.domain.model.UsefulHabitFrequency

@Entity(tableName = "useful_habits")
data class UsefulHabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val frequency: UsefulHabitFrequency,
    @ColumnInfo(defaultValue = "1")
    val repeat: Int = 1
)
