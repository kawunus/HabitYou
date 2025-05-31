package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.NoteRepository
import com.kawunus.habityou.domain.api.usecase.EditNoteInteractor
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNoteDto

class EditNoteInteractorImpl(private val repository: NoteRepository) : EditNoteInteractor {

    override suspend fun editNote(oldNote: Note, newNote: Note, habitId: Int) {
        repository.updateNote(oldNote.toNoteDto(), newNote.toNoteDto(), habitId)
    }

    override suspend fun deleteNote(note: Note) {
        repository.deleteNote(note.toNoteDto())
    }
}