package com.kawunus.habityou.data.dto

import java.time.LocalDate

data class EntryDto(
    val id: Int,
    val habitId: Int,
    val date: LocalDate
)