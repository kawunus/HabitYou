package com.kawunus.habityou.usefulhabits.presentation.viewmodel

import com.kawunus.habityou.usefulhabits.domain.model.Habit
import java.time.LocalDate

sealed class UsefulHabitScreenState {

    data object Empty : UsefulHabitScreenState()

    data object Loading : UsefulHabitScreenState()

    data class Content(
        val habits: List<Habit>,
        val todaysDate: LocalDate,
        val showStreaks: Boolean,
        val showScore: Boolean,
        val showSubtitle: Boolean,
    ) : UsefulHabitScreenState()
}