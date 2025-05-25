package com.kawunus.habityou.domain.api.usecase

import com.kawunus.habityou.domain.model.Entry

interface NewEntryUseCase {

    suspend operator fun invoke(entry: Entry)

}