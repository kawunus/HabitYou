package com.kawunus.habityou.ui.screens.usefulhabitinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.model.UsefulHabit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UsefulHabitDetailsViewModel(
    private val calculateStreaks: CalculateStreaksUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UsefulHabitDetailsScreenState>(
        UsefulHabitDetailsScreenState.Loading
    )
    val state = _state.asStateFlow()

    fun getData(habit: UsefulHabit) {
        viewModelScope.launch {

            val total = habit.completed.size
            val longestStreak = calculateStreaks(habit.id).first().maxByOrNull {
                it.length
            }?.length ?: 0
            val startedAt = habit.completed.sortedBy { date ->
                date
            }[0]

            val contentState = UsefulHabitDetailsScreenState.Content(
                frequencyResId = habit.type.userReadableStringRes,
                habitName = habit.name,
                score = habit.score?.toFloat() ?: 0f,
                streak = habit.streak ?: 0,
                total = total,
                longestStreak = longestStreak,
                startedAt = startedAt.toString(),
            )
            renderState(contentState)
        }
    }

    private fun renderState(state: UsefulHabitDetailsScreenState) {
        _state.value = state
    }
}