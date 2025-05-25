package com.kawunus.habityou.ui.usefulhabits.viewmodel

import com.kawunus.habityou.domain.model.UsefulHabit
import java.time.LocalDate

sealed class UsefulHabitsScreenState {

    data object Empty : UsefulHabitsScreenState()

    data object Loading : UsefulHabitsScreenState()

    data class Content(
        val usefulHabits: List<UsefulHabit>,
        val todaysDate: LocalDate,
        val showStreaks: Boolean,
        val showScore: Boolean,
        val showSubtitle: Boolean,
    ) : UsefulHabitsScreenState()
}