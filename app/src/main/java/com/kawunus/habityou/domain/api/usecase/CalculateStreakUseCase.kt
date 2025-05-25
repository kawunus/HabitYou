package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Streak
import kotlinx.coroutines.flow.Flow

interface CalculateStreakUseCase {

    suspend operator fun invoke(habitId: Int): Flow<List<Streak>>
}