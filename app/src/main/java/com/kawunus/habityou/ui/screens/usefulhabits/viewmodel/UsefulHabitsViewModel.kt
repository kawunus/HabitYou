package com.kawunus.habityou.ui.screens.usefulhabits.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.CalculateScoreUseCase
import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.api.usecase.GetUsefulHabitsWithEntriesUseCase
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.model.Entry
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.domain.model.UsefulHabitWithEntries
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.Clock
import java.time.LocalDate

class UsefulHabitsViewModel(
    private val newEntry: NewEntryUseCase,
    private val calculateStreaks: CalculateStreaksUseCase,
    private val calculateScore: CalculateScoreUseCase,
    private val clock: Clock,
    private val getUsefulHabitsWithEntries: GetUsefulHabitsWithEntriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UsefulHabitsScreenState>(UsefulHabitsScreenState.Loading)
    val state: StateFlow<UsefulHabitsScreenState> = _state

    fun toggleEntry(habitId: Int, date: LocalDate) {
        viewModelScope.launch {
            newEntry(Entry(habitId = habitId, date = date))
        }
    }

    fun getData() {
        viewModelScope.launch {
            getUsefulHabitsWithEntries().collectLatest { habitsList ->
                processResult(habitsList)
            }
        }
    }

    private suspend fun processResult(habitsList: List<UsefulHabitWithEntries>) {
        if (habitsList.isEmpty()) {
            renderState(UsefulHabitsScreenState.Empty)
        } else {
            val habits = habitsList.map { habitWithEntries ->
                val habit = habitWithEntries.habit
                val entries = habitWithEntries.entries
                val streak = calculateStreaks(habit.id).first().find { streak ->
                    streak.endDate == LocalDate.now(clock) || streak.endDate == LocalDate.now(clock)
                        .minusDays(1)
                }
                var score = calculateScore(habit.id).first()?.times(100)?.toInt()
                if (score == 0) score = null
                val completed = entries.filter { it.id != null }.map { it.date }.sortedDescending()
                val completedByWeek =
                    entries.filter { it.id == null }.map { it.date }.sortedDescending()
                UsefulHabit(
                    id = habit.id,
                    name = habit.name,
                    type = habit.frequency,
                    streak = streak?.length,
                    score = score,
                    completed = completed,
                    completedByWeek = completedByWeek,
                )
            }
            renderState(
                UsefulHabitsScreenState.Content(
                    usefulHabits = habits,
                    todaysDate = LocalDate.now(clock),
                    showStreaks = true,
                    showScore = true,
                    showSubtitle = false
                )
            )
        }
    }

    private fun renderState(state: UsefulHabitsScreenState) {
        _state.value = state
    }
}