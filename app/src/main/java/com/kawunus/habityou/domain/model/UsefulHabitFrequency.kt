package com.kawunus.habityou.domain.model

import androidx.annotation.StringRes
import com.kawunus.habityou.R

enum class UsefulHabitFrequency(@StringRes val userReadableStringRes: Int) {
    DAILY(R.string.useful_habit_frequency_dayly)
}