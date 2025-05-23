package com.kawunus.habitu.diary.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.kawunus.habitu.diary.domain.api.NoteRepository

class DiaryViewModel(
    private val noteRepository: NoteRepository
) : ViewModel()