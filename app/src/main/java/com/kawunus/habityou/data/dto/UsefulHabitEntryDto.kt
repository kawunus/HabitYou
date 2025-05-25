package com.kawunus.habityou.data.dto

import java.time.LocalDate

data class UsefulHabitEntryDto(
    val id: Int,
    val usefulHabitId: Int,
    val date: LocalDate,
    val isCompleted: Boolean
)