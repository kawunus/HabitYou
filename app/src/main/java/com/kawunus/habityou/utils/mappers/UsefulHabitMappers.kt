package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.data.database.entity.UsefulHabitEntity
import com.kawunus.habityou.data.dto.UsefulHabitDto

fun UsefulHabitEntity.toUsefulHabitDto(): UsefulHabitDto {
    return UsefulHabitDto(
        id = id,
        name = name,
        frequency = frequency,
        streak = streak,
        score = score
    )
}

fun UsefulHabitDto.toUsefulHabitEntity(): UsefulHabitEntity {
    return UsefulHabitEntity(
        id = id,
        name = name,
        frequency = frequency,
        streak = streak,
        score = score
    )
}