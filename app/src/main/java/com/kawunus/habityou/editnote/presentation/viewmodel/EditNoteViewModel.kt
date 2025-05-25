package com.kawunus.habityou.editnote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.editnote.domain.api.EditNoteUseCase
import com.kawunus.habityou.editnote.presentation.viewmodel.EditNoteScreenState.ReadyToEdit
import com.kawunus.habityou.notes.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditNoteViewModel(private val editNoteUseCase: EditNoteUseCase) : ViewModel() {

    private val _state = MutableStateFlow<EditNoteScreenState>(ReadyToEdit)
    val state = _state.asStateFlow()

    fun editNote(note: Note) {
        viewModelScope.launch {
            editNoteUseCase.execute(note)
            _state.value = EditNoteScreenState.Done
        }

    }

}