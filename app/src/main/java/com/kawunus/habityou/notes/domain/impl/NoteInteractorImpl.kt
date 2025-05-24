package com.kawunus.habityou.notes.domain.impl

import com.kawunus.habityou.notes.domain.api.NoteInteractor
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.notes.domain.model.Note
import com.kawunus.habityou.utils.toNote
import com.kawunus.habityou.utils.toNoteDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteInteractorImpl(private val noteRepository: NoteRepository) : NoteInteractor {

    override suspend fun insertNote(note: Note) {
        noteRepository.insertNote(note.toNoteDto())
    }

    override suspend fun deleteNote(note: Note) {
        noteRepository.deleteNote(note.toNoteDto())
    }

    override suspend fun updateNote(note: Note) {
        noteRepository.updateNote(note.toNoteDto())
    }

    override suspend fun getAllNotes(): Flow<List<Note>> {
        return noteRepository.getAllNotes().map { noteList ->
            noteList.map { it.toNote() }
        }
    }
}