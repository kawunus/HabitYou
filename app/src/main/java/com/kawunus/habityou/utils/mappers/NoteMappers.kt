package com.kawunus.habityou.utils.mappers

import com.kawunus.habityou.core.database.entity.NoteEntity
import com.kawunus.habityou.notes.data.dto.NoteDto
import com.kawunus.habityou.notes.domain.model.Note

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
        title = title
    )
}

fun Note.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date,
        title = title
    )
}

fun NoteDto.toNote(): Note {
    return Note(
        id = id,
        content = content,
        date = date,
        title = title
    )
}