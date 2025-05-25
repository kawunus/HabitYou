package com.kawunus.habityou.newnote.domain.impl

import com.kawunus.habityou.newnote.domain.api.NewNoteUseCase
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.notes.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNoteDto

class NewNoteUseCaseImpl(private val repository: NoteRepository) : NewNoteUseCase {

    override suspend fun execute(note: Note) {
        repository.insertNote(note.toNoteDto())
    }
}