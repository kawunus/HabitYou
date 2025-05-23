package com.kawunus.habitu.di

import com.kawunus.habitu.notes.data.impl.NoteRepositoryImpl
import com.kawunus.habitu.notes.domain.api.NoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::NoteRepositoryImpl) { bind<NoteRepository>() }
}