package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.EditNoteInteractor
import com.kawunus.habityou.domain.api.NoteRepository
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNoteDto

class EditNoteInteractorImpl(private val repository: NoteRepository) : EditNoteInteractor {

    override suspend fun editNote(note: Note) {
        repository.updateNote(note.toNoteDto())
    }

    override suspend fun deleteNote(note: Note) {
        repository.deleteNote(note.toNoteDto())
    }
}