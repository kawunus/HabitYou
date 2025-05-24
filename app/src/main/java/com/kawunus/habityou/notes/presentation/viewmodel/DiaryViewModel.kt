package com.kawunus.habityou.notes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.notes.domain.api.NoteInteractor
import com.kawunus.habityou.notes.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class DiaryViewModel(
    private val noteInteractor: NoteInteractor
) : ViewModel() {

    private val _state = MutableStateFlow<DiaryScreenState>(DiaryScreenState.Loading)
    val state: StateFlow<DiaryScreenState> = _state

    fun getData() {
        renderState(DiaryScreenState.Loading)

        viewModelScope.launch {
            noteInteractor.getAllNotes().collect { notesList ->
                processResult(notesList)
            }
        }
    }

    private fun updateData() {
        viewModelScope.launch {
            noteInteractor.getAllNotes().collect { notesList ->
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
            noteInteractor.deleteNote(note)
            updateData()
        }
    }

    fun insertNote(note: Note = Note(title = "test", content = "test", date = Random.nextLong())) {
        viewModelScope.launch {
            noteInteractor.insertNote(note)
            updateData()
        }
    }
}