package com.kawunus.habityou.ui.screens.diary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.DiaryInteractor
import com.kawunus.habityou.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DiaryViewModel(
    private val diaryInteractor: DiaryInteractor
) : ViewModel() {

    private val _state = MutableStateFlow<DiaryScreenState>(DiaryScreenState.Loading)
    val state: StateFlow<DiaryScreenState> = _state

    fun getData() {
        renderState(DiaryScreenState.Loading)

        viewModelScope.launch {
            diaryInteractor.getAllNotes().collect { notesList ->
                processResult(notesList)
            }
        }
    }

    private fun updateData() {
        viewModelScope.launch {
            diaryInteractor.getAllNotes().collect { notesList ->
                processResult(notesList)
            }
        }
    }

    private fun renderState(state: DiaryScreenState) {
        _state.value = state
    }

    private fun processResult(notesList: List<Note>) {
        if (notesList.isEmpty()) {
            renderState(DiaryScreenState.Empty)
        } else {
            renderState(DiaryScreenState.Content(notesList))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            diaryInteractor.deleteNote(note)
            updateData()
        }
    }
}