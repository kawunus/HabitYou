package com.kawunus.habityou.notes.domain.api

import com.kawunus.habityou.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface DiaryInteractor {

    suspend fun deleteNote(note: Note)

    suspend fun getAllNotes(): Flow<List<Note>>
}