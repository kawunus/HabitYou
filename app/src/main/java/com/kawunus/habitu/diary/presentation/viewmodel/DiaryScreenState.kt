package com.kawunus.habitu.diary.presentation.viewmodel

import com.kawunus.habitu.diary.domain.model.Note

sealed class DiaryScreenState {

    object Loading : DiaryScreenState()

    object Empty : DiaryScreenState()

    data class Content(val content: List<Note>) : DiaryScreenState()
}