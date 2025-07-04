package com.kawunus.habityou.domain.api.repository

import com.kawunus.habityou.data.dto.NoteDto
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: NoteDto)

    suspend fun deleteNote(note: NoteDto)

    suspend fun updateNote(note: NoteDto)

    fun getAllNotes(): Flow<List<NoteDto>>
}