package com.kawunus.habityou.data.dto

import com.kawunus.habityou.domain.model.UsefulHabitFrequency

data class UsefulHabitDto(
    val id: Int = 0,
    val name: String,
    val frequency: UsefulHabitFrequency,
    val repeat: Int = 1
)