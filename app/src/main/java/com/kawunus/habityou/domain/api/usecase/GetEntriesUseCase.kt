package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Entry
import kotlinx.coroutines.flow.Flow

interface GetEntriesUseCase {

    suspend operator fun invoke(habitId: Int): Flow<List<Entry>>
}