package com.kawunus.habityou.data.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BadHabitNoteWithHabitsEntity(
    @Embedded val habit: BadHabitEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "useful_habit_id"
    )
    val notes: List<BadHabitNoteEntity>
)