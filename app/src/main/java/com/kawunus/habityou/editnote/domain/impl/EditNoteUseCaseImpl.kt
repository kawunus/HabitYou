package com.kawunus.habityou.editnote.domain.impl

import com.kawunus.habityou.editnote.domain.api.EditNoteUseCase
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.notes.domain.model.Note
import com.kawunus.habityou.utils.toNoteDto

class EditNoteUseCaseImpl(private val repository: NoteRepository) : EditNoteUseCase {

    override suspend fun execute(note: Note) {
        repository.updateNote(note.toNoteDto())
    }

}