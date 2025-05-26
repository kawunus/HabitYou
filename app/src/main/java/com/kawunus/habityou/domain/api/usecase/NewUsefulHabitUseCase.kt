package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.UsefulHabitFrequency

interface NewUsefulHabitUseCase {

    suspend operator fun invoke(title: String, frequency: UsefulHabitFrequency, repeat: Int = 1)

}