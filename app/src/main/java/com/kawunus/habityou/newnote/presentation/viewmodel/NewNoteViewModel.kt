package com.kawunus.habityou.newnote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.newnote.domain.api.NewNoteUseCase
import com.kawunus.habityou.notes.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewNoteViewModel(private val newNoteUseCase: NewNoteUseCase) : ViewModel() {

    private val _state = MutableStateFlow<NewNoteState>(NewNoteState.ReadyToCreate)
    val state = _state.asStateFlow()

    fun createNote(title: String, content: String) {
        viewModelScope.launch {
            newNoteUseCase.execute(
                Note(
                    title = title,
                    content = content,
                    date = System.currentTimeMillis()
                )
            )
            _state.value = NewNoteState.Done
        }
    }
}