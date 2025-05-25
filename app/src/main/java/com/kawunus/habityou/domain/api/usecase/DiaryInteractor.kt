package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface DiaryInteractor {

    suspend fun deleteNote(note: Note)

    suspend fun getAllNotes(): Flow<List<Note>>
}