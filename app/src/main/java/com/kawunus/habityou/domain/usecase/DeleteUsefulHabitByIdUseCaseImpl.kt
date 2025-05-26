package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.domain.api.usecase.DeleteUsefulHabitByIdUseCase

class DeleteUsefulHabitByIdUseCaseImpl(private val repository: UsefulHabitRepository) :
    DeleteUsefulHabitByIdUseCase {
    override suspend fun invoke(habitId: Int) {
        repository.deleteUsefulHabitById(habitId)
    }
}