package com.kawunus.habityou.ui.screens.newnote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.NewNoteUseCase
import com.kawunus.habityou.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewNoteViewModel(private val newNote: NewNoteUseCase) : ViewModel() {

    private val _state = MutableStateFlow<NewNoteScreenState>(NewNoteScreenState.ReadyToCreate)
    val state = _state.asStateFlow()

    fun createNote(title: String, content: String) {
        viewModelScope.launch {
            newNote(
                Note(
                    title = title,
                    content = content,
                    date = System.currentTimeMillis()
                )
            )
            _state.value = NewNoteScreenState.Done
        }
    }
}