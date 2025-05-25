package com.kawunus.habityou.di

import com.kawunus.habityou.domain.api.usecase.DiaryInteractor
import com.kawunus.habityou.domain.api.usecase.EditNoteInteractor
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.api.usecase.NewNoteUseCase
import com.kawunus.habityou.domain.usecase.DiaryInteractorImpl
import com.kawunus.habityou.domain.usecase.EditNoteInteractorImpl
import com.kawunus.habityou.domain.usecase.NewEntryUseCaseImpl
import com.kawunus.habityou.domain.usecase.NewNoteUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::DiaryInteractorImpl) { bind<DiaryInteractor>() }

    singleOf(::NewNoteUseCaseImpl) { bind<NewNoteUseCase>() }

    singleOf(::EditNoteInteractorImpl) { bind<EditNoteInteractor>() }

    singleOf(::NewEntryUseCaseImpl) { bind<NewEntryUseCase>() }
}