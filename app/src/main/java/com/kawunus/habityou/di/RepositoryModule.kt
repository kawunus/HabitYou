package com.kawunus.habityou.di

import com.kawunus.habityou.data.impl.EntryRepositoryImpl
import com.kawunus.habityou.data.impl.NoteRepositoryImpl
import com.kawunus.habityou.data.impl.UsefulHabitRepositoryImpl
import com.kawunus.habityou.domain.api.EntryRepository
import com.kawunus.habityou.domain.api.NoteRepository
import com.kawunus.habityou.domain.api.UsefulHabitsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::NoteRepositoryImpl) { bind<NoteRepository>() }

    singleOf(::UsefulHabitRepositoryImpl) { bind<UsefulHabitsRepository>() }

    singleOf(::EntryRepositoryImpl) { bind<EntryRepository>() }
}