package com.kawunus.habityou.ui.usefulhabits.viewmodel

import com.kawunus.habityou.domain.model.UsefulHabit
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