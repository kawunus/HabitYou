package com.kawunus.habityou.usefulhabits.presentation.viewmodel

import com.kawunus.habityou.usefulhabits.domain.model.UsefulHabit
import java.time.LocalDate

sealed class UsefulHabitScreenState {

    data object Empty : UsefulHabitScreenState()

    data object Loading : UsefulHabitScreenState()

    data class Content(
        val usefulHabits: List<UsefulHabit>,
        val todaysDate: LocalDate,
        val showStreaks: Boolean,
        val showScore: Boolean,
        val showSubtitle: Boolean,
    ) : UsefulHabitScreenState()
}