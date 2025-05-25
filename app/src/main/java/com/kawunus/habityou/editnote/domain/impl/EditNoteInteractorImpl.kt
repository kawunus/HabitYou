package com.kawunus.habityou.editnote.domain.impl

import com.kawunus.habityou.editnote.domain.api.EditNoteInteractor
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.notes.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNoteDto

class EditNoteInteractorImpl(private val repository: NoteRepository) : EditNoteInteractor {

    override suspend fun editNote(note: Note) {
        repository.updateNote(note.toNoteDto())
    }

    override suspend fun deleteNote(note: Note) {
        repository.deleteNote(note.toNoteDto())
    }
}