package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.data.database.entity.EntryEntity
import com.kawunus.habityou.data.dto.EntryDto

fun EntryDto.toEntryEntity(): EntryEntity {
    return EntryEntity(
        id = id,
        habitId = habitId,
        date = date
    )
}

fun EntryEntity.toEntryDto(): EntryDto {
    return EntryDto(
        id = id,
        habitId = habitId,
        date = date
    )
}