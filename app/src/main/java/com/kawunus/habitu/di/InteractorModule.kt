package com.kawunus.habitu.di

import com.kawunus.habitu.diary.domain.api.NoteInteractor
import com.kawunus.habitu.diary.domain.impl.NoteInteractorImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::NoteInteractorImpl) { bind<NoteInteractor>() }
}