package com.kawunus.habityou.notes.domain.impl

import com.kawunus.habityou.notes.domain.api.DiaryInteractor
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.notes.domain.model.Note
import com.kawunus.habityou.utils.mappers.toNote
import com.kawunus.habityou.utils.mappers.toNoteDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DiaryInteractorImpl(private val noteRepository: NoteRepository) : DiaryInteractor {

    override suspend fun deleteNote(note: Note) {
        noteRepository.deleteNote(note.toNoteDto())
    }

    override suspend fun getAllNotes(): Flow<List<Note>> {
        return noteRepository.getAllNotes().map { noteList ->
            noteList.map { it.toNote() }
        }
    }
}