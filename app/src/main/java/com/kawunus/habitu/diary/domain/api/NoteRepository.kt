package com.kawunus.habitu.diary.domain.api

import com.kawunus.habitu.diary.data.dto.NoteDto
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: NoteDto)

    suspend fun deleteNote(note: NoteDto)

    suspend fun updateNote(note: NoteDto)

    suspend fun getAllNotes(): Flow<List<NoteDto>>
}