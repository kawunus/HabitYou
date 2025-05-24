package com.kawunus.habityou.notes.presentation.viewmodel

import com.kawunus.habityou.notes.domain.model.Note

sealed class DiaryScreenState {

    object Loading : DiaryScreenState()

    object Empty : DiaryScreenState()

    data class Content(val content: List<Note>) : DiaryScreenState()
}