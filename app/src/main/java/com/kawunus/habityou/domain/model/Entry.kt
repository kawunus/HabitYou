package com.kawunus.habityou.domain.model

import java.time.LocalDate

data class Entry(
    val id: Int = 0,
    val habitId: Int,
    val date: LocalDate
)