package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.data.database.entity.UsefulHabitWithEntriesEntity
import com.kawunus.habityou.data.dto.UsefulHabitsWithEntriesDto

fun UsefulHabitsWithEntriesDto.toUsefulHabitsWithEntriesEntity(): UsefulHabitWithEntriesEntity {
    return UsefulHabitWithEntriesEntity(
        habit = this.usefulHabit.toUsefulHabitEntity(),
        entries = this.entries.map { it.toEntryEntity() }
    )
}

fun UsefulHabitWithEntriesEntity.toUsefulHabitsWithEntriesDto(): UsefulHabitsWithEntriesDto {
    return UsefulHabitsWithEntriesDto(
        usefulHabit = this.habit.toUsefulHabitDto(),
        entries = this.entries.map { it.toEntryDto() }
    )
}