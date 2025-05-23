package com.kawunus.habitu.utils

import com.kawunus.habitu.core.database.entity.NoteEntity
import com.kawunus.habitu.diary.data.dto.NoteDto
import com.kawunus.habitu.diary.domain.model.Note

fun NoteDto.toNoteEntity(): NoteEntity {
    return NoteEntity(
        content = content,
        date = date
    )
}

fun NoteEntity.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date
    )
}

fun Note.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        content = content,
        date = date
    )
}

fun NoteDto.toNote(): Note {
    return Note(
        id = id,
        content = content,
        date = date
    )
}