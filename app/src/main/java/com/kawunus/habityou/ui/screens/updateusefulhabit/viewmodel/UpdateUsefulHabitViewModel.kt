package com.kawunus.habityou.ui.screens.updateusefulhabit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.DeleteUsefulHabitByIdUseCase
import com.kawunus.habityou.domain.api.usecase.UpdateUsefulHabitUseCase
import com.kawunus.habityou.domain.model.UsefulHabit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UpdateUsefulHabitViewModel(
    private val deleteUsefulHabitById: DeleteUsefulHabitByIdUseCase,
    private val updateUsefulHabit: UpdateUsefulHabitUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<UpdateUsefulHabitScreenState>(UpdateUsefulHabitScreenState.ReadyToUpdate)
    val state = _state.asStateFlow()

    fun deleteHabit(habit: UsefulHabit) {
        viewModelScope.launch {
            deleteUsefulHabitById(habitId = habit.id)
            renderState(UpdateUsefulHabitScreenState.Deleted)
        }
    }

    fun updateHabit(habit: UsefulHabit) {
        viewModelScope.launch {
            updateUsefulHabit(habit)
            renderState(UpdateUsefulHabitScreenState.Updated)
        }
    }

    private fun renderState(state: UpdateUsefulHabitScreenState) {
        _state.value = state
    }
}