package com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.NewUsefulHabitUseCase
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewUsefulHabitViewModel(
    private val newUsefulHabit: NewUsefulHabitUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<NewUsefulHabitScreenState>(NewUsefulHabitScreenState.ReadyToCreate)
    val state = _state.asStateFlow()

    fun insertUsefulHabit(title: String, frequency: UsefulHabitFrequency) {
        viewModelScope.launch {
            newUsefulHabit(title, frequency)
            _state.value = NewUsefulHabitScreenState.Created
        }
    }
}