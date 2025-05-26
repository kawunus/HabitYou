package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Note

interface NewNoteUseCase {

    suspend operator fun invoke(note: Note)
}