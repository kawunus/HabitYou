package com.kawunus.habityou.editnote.domain.api

import com.kawunus.habityou.notes.domain.model.Note

interface EditNoteInteractor {

    suspend fun editNote(note: Note)

    suspend fun deleteNote(note: Note)

}