package com.kawunus.habityou.data.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UsefulHabitWithEntries(
    @Embedded val habit: UsefulHabitEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "useful_habit_id"
    )
    val entries: List<EntryEntity>
)