package com.kawunus.habityou.ui.screens.usefulhabitinfo.viewmodel

import java.time.LocalDate

sealed class UsefulHabitDetailsScreenState {

    data class Content(
        val habitName: String,
        val frequencyResId: Int,
        val score: Float,
        val streak: Int,
        val longestStreak: Int,
        val startedAt: LocalDate? = null,
        val total: Int,
    ) : UsefulHabitDetailsScreenState()

    data object Loading : UsefulHabitDetailsScreenState()

    data object Deleted : UsefulHabitDetailsScreenState()
}