package com.kawunus.habityou.domain.model

import java.time.LocalDate

data class UsefulHabit(
    val id: Int,
    val name: String,
    val type: UsefulHabitFrequency,
    val streak: Int?,
    val score: Int?,
    val completed: List<LocalDate>,
    val completedByWeek: List<LocalDate>,
    val repeat: Int
) {
    fun hasBeenCompleted(date: LocalDate): Boolean {
        return when (type) {
            UsefulHabitFrequency.DAILY -> completed.contains(date)
        }
    }
}