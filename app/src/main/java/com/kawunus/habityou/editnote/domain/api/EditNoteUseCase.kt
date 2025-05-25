package com.kawunus.habityou.editnote.domain.api

import com.kawunus.habityou.notes.domain.model.Note

interface EditNoteUseCase {

    suspend fun execute(note: Note)
}