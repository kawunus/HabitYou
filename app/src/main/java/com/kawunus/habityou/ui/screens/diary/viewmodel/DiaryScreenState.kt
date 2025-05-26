package com.kawunus.habityou.ui.screens.diary.viewmodel

import com.kawunus.habityou.domain.model.Note

sealed class DiaryScreenState {

    object Loading : DiaryScreenState()

    object Empty : DiaryScreenState()

    data class Content(val content: List<Note>) : DiaryScreenState()
}