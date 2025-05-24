package com.kawunus.habityou.di

import com.kawunus.habityou.notes.data.impl.NoteRepositoryImpl
import com.kawunus.habityou.notes.domain.api.NoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::NoteRepositoryImpl) { bind<NoteRepository>() }
}