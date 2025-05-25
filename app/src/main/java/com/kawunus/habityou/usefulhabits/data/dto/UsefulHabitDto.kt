package com.kawunus.habityou.usefulhabits.data.dto

import com.kawunus.habityou.usefulhabits.domain.model.UsefulHabitFrequency
import java.time.LocalDate

data class UsefulHabitDto(
    val id: Int,
    val name: String,
    val type: UsefulHabitFrequency,
    val streak: Int?,
    val score: Int?,
    val completed: List<LocalDate>,
    val completedByWeek: List<LocalDate>
)