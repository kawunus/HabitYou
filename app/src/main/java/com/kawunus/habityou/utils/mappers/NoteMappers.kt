package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.data.database.entity.BadHabitNoteEntity
import com.kawunus.habityou.data.database.entity.NoteEntity
import com.kawunus.habityou.data.database.entity.UsefulHabitNoteEntity
import com.kawunus.habityou.data.dto.NoteDto
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.domain.model.NoteType

fun NoteDto.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        content = content,
        date = date,
        title = title
    )
}

fun NoteEntity.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date,
        title = title,
        type = NoteType.NONE
    )
}

fun Note.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date,
        title = title,
        type = type
    )
}

fun NoteDto.toNote(): Note {
    return Note(
        id = id,
        content = content,
        date = date,
        title = title,
        type = type
    )
}

fun UsefulHabitNoteEntity.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date,
        title = title,
        type = NoteType.USEFUL_HABIT
    )
}

fun BadHabitNoteEntity.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date,
        title = title,
        type = NoteType.BAD_HABIT
    )
}

fun NoteDto.toUsefulHabitNoteEntity(habitId: Int): UsefulHabitNoteEntity {
    return UsefulHabitNoteEntity(
        id = id,
        content = content,
        date = date,
        title = title,
        usefulHabitId = habitId
    )
}

fun NoteDto.toBadHabitNoteEntity(habitId: Int): BadHabitNoteEntity {
    return BadHabitNoteEntity(
        id = id,
        content = content,
        date = date,
        title = title,
        badHabitId = habitId
    )
}