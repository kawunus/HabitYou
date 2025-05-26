package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.data.database.entity.UsefulHabitEntity
import com.kawunus.habityou.data.dto.UsefulHabitDto
import com.kawunus.habityou.domain.model.UsefulHabit

fun UsefulHabitEntity.toUsefulHabitDto(): UsefulHabitDto {
    return UsefulHabitDto(
        id = id,
        name = name,
        frequency = frequency,
        repeat = repeat
    )
}

fun UsefulHabitDto.toUsefulHabitEntity(): UsefulHabitEntity {
    return UsefulHabitEntity(
        id = id,
        name = name,
        frequency = frequency,
        repeat = repeat
    )
}

fun UsefulHabit.toUsefulHabitDto(): UsefulHabitDto {
    return UsefulHabitDto(
        id = id,
        name = name,
        frequency = type,
        repeat = repeat
    )
}