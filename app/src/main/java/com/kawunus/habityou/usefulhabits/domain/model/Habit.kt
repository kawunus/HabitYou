package com.kawunus.habityou.usefulhabits.domain.model

import java.time.LocalDate

data class Habit(
    val id: Int,
    val name: String,
    val type: HabitFrequency,
    val streak: Int?,
    val score: Int?,
    val completed: List<LocalDate>,
    val completedByWeek: List<LocalDate>
) {
    fun hasBeenCompleted(date: LocalDate): Boolean {
        return when (type) {
            HabitFrequency.DAILY -> completed.contains(date)
        }
    }
}