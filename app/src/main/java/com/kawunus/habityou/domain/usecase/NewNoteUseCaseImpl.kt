package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.NoteRepository
import com.kawunus.habityou.domain.api.usecase.NewNoteUseCase
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNoteDto

class NewNoteUseCaseImpl(private val repository: NoteRepository) : NewNoteUseCase {

    override suspend fun execute(note: Note) {
        repository.insertNote(note.toNoteDto())
    }
}