package com.kawunus.habityou.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kawunus.habityou.usefulhabits.domain.model.UsefulHabitFrequency

@Entity(tableName = "useful_habits")
data class UsefulHabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: UsefulHabitFrequency,
    val streak: Int?,
    val score: Int?,
)
