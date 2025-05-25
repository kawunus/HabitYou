package com.kawunus.habityou.ui.editnote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.EditNoteInteractor
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.ui.editnote.viewmodel.EditNoteScreenState.ReadyToEdit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditNoteViewModel(private val editNoteInteractor: EditNoteInteractor) : ViewModel() {

    private val _state = MutableStateFlow<EditNoteScreenState>(ReadyToEdit)
    val state = _state.asStateFlow()

    fun editNote(note: Note) {
        viewModelScope.launch {
            editNoteInteractor.editNote(note)
            _state.value = EditNoteScreenState.Edited
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            editNoteInteractor.deleteNote(note)
            _state.value = EditNoteScreenState.Deleted
        }
    }

}