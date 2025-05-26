package com.kawunus.habityou.domain.model

import java.time.LocalDate

data class Streak(
    val length: Int,
    val endDate: LocalDate,
)