package com.kawunus.habityou.data.dto

import com.kawunus.habityou.domain.model.UsefulHabitFrequency

data class UsefulHabitDto(
    val id: Int,
    val name: String,
    val frequency: UsefulHabitFrequency,
    val streak: Int?,
    val score: Int?,
)