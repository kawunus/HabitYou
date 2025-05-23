package com.kawunus.habitu.notes.domain.api

import com.kawunus.habitu.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteInteractor {

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun getAllNotes(): Flow<List<Note>>
}