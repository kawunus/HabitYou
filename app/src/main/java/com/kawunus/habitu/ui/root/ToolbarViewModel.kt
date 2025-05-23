package com.kawunus.habitu.ui.root

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ToolbarViewModel : ViewModel() {

    private val _title = MutableStateFlow("Habitu")
    val title: StateFlow<String> = _title

    fun setTitle(newTitle: String) {
        _title.value = newTitle
    }
}