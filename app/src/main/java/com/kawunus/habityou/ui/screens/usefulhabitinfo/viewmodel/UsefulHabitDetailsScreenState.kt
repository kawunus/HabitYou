package com.kawunus.habityou.ui.screens.usefulhabitinfo.viewmodel

sealed class UsefulHabitDetailsScreenState {

    data class Content(
        val habitName: String,
        val frequencyResId: Int,
        val score: Float,
        val streak: Int,
        val longestStreak: Int,
        val startedAt: String,
        val total: Int,
    ) : UsefulHabitDetailsScreenState()

    object Loading : UsefulHabitDetailsScreenState()

    object Deleted : UsefulHabitDetailsScreenState()
}