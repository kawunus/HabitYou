package com.kawunus.habitu.diary.domain.impl

import com.kawunus.habitu.diary.domain.api.NoteInteractor
import com.kawunus.habitu.diary.domain.api.NoteRepository
import com.kawunus.habitu.diary.domain.model.Note
import com.kawunus.habitu.utils.toNote
import com.kawunus.habitu.utils.toNoteDto
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