package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.EntryRepository
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.model.Entry
import com.kawunus.habityou.utils.mappers.toEntryDto

class NewEntryUseCaseImpl(private val repository: EntryRepository) : NewEntryUseCase {
    override suspend fun invoke(entry: Entry) {
        repository.toggleEntry(entry.toEntryDto())
    }
}