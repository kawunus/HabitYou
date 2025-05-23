package com.kawunus.habitu.notes.presentation.viewmodel

import com.kawunus.habitu.notes.domain.model.Note

sealed class DiaryScreenState {

    object Loading : DiaryScreenState()

    object Empty : DiaryScreenState()

    data class Content(val content: List<Note>) : DiaryScreenState()
}