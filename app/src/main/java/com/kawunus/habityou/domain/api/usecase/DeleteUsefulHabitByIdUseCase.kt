package com.kawunus.habityou.domain.api.usecase

interface DeleteUsefulHabitByIdUseCase {

    suspend operator fun invoke(habitId: Int)
}