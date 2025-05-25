package com.kawunus.habityou.ui.screens.root.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.kawunus.habityou.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ToolbarViewModel : ViewModel() {

    private val _titleStringRes = MutableStateFlow(R.string.app_name)
    val titleStringRes: StateFlow<Int> = _titleStringRes

    fun setTitleStringRes(@StringRes newTitle: Int) {
        _titleStringRes.value = newTitle
    }
}