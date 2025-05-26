package com.kawunus.habityou.domain.api.usecase

import kotlinx.coroutines.flow.Flow

interface CalculateScoreUseCase {

    operator fun invoke(habitId: Int): Flow<Float?>
}