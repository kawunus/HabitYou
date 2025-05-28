package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Note

interface EditNoteInteractor {

    suspend fun editNote(oldNote: Note, newNote: Note, habitId: Int)

    suspend fun deleteNote(note: Note)

}