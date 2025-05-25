package com.kawunus.habityou.di

import com.kawunus.habityou.data.impl.EntryRepositoryImpl
import com.kawunus.habityou.data.impl.NoteRepositoryImpl
import com.kawunus.habityou.data.impl.UsefulHabitRepositoryImpl
import com.kawunus.habityou.data.impl.UsefulHabitWithEntriesRepositoryImpl
import com.kawunus.habityou.domain.api.repository.EntryRepository
import com.kawunus.habityou.domain.api.repository.NoteRepository
import com.kawunus.habityou.domain.api.repository.UsefulHabitWithEntriesRepository
import com.kawunus.habityou.domain.api.repository.UsefulHabitsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::NoteRepositoryImpl) { bind<NoteRepository>() }

    singleOf(::UsefulHabitRepositoryImpl) { bind<UsefulHabitsRepository>() }

    singleOf(::EntryRepositoryImpl) { bind<EntryRepository>() }

    singleOf(::UsefulHabitWithEntriesRepositoryImpl) { bind<UsefulHabitWithEntriesRepository>() }
}