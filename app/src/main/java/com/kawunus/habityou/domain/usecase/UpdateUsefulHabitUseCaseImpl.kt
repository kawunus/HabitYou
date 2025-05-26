package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.domain.api.usecase.UpdateUsefulHabitUseCase
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.utils.mappers.toUsefulHabitDto

class UpdateUsefulHabitUseCaseImpl(private val repository: UsefulHabitRepository) :
    UpdateUsefulHabitUseCase {

    override suspend fun invoke(habit: UsefulHabit) {
        repository.updateUsefulHabit(habit.toUsefulHabitDto())
    }
}