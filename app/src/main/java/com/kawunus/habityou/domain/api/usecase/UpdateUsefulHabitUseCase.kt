package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.UsefulHabit

interface UpdateUsefulHabitUseCase {

    suspend operator fun invoke(habit: UsefulHabit)
}