package com.kawunus.habityou.di

import com.kawunus.habityou.notes.domain.api.NoteInteractor
import com.kawunus.habityou.notes.domain.impl.NoteInteractorImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::NoteInteractorImpl) { bind<NoteInteractor>() }
}