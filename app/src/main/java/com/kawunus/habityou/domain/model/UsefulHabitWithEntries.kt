package com.kawunus.habityou.domain.model

import com.kawunus.habityou.data.dto.UsefulHabitDto

data class UsefulHabitWithEntries(
    val habit: UsefulHabitDto,
    val entries: List<Entry>
)
