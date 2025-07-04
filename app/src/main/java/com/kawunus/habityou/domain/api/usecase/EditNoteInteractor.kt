package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Note

interface EditNoteInteractor {

    suspend fun editNote(note: Note)

    suspend fun deleteNote(note: Note)

}