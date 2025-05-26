package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.data.dto.UsefulHabitDto
import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.domain.api.usecase.NewUsefulHabitUseCase
import com.kawunus.habityou.domain.model.UsefulHabitFrequency

class NewUsefulHabitUseCaseImpl(private val repository: UsefulHabitRepository) :
    NewUsefulHabitUseCase {
    override suspend fun invoke(
        title: String,
        frequency: UsefulHabitFrequency,
        repeat: Int
    ) {
        repository.insertUsefulHabit(
            UsefulHabitDto(
                name = title,
                frequency = frequency,
                repeat = repeat
            )
        )
    }
}