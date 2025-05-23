package com.kawunus.habitu.utils

import com.kawunus.habitu.core.database.entity.NoteEntity
import com.kawunus.habitu.notes.data.dto.NoteDto
import com.kawunus.habitu.notes.domain.model.Note

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