package com.kawunus.habityou.newnote.domain.api

import com.kawunus.habityou.notes.domain.model.Note

interface NewNoteUseCase {

    suspend fun execute(note: Note)
}