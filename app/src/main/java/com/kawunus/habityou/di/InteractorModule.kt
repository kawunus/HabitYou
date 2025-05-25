package com.kawunus.habityou.di

import com.kawunus.habityou.domain.api.DiaryInteractor
import com.kawunus.habityou.domain.api.EditNoteInteractor
import com.kawunus.habityou.domain.api.NewNoteUseCase
import com.kawunus.habityou.domain.usecase.DiaryInteractorImpl
import com.kawunus.habityou.domain.usecase.EditNoteInteractorImpl
import com.kawunus.habityou.domain.usecase.NewNoteUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::DiaryInteractorImpl) { bind<DiaryInteractor>() }

    singleOf(::NewNoteUseCaseImpl) { bind<NewNoteUseCase>() }

    singleOf(::EditNoteInteractorImpl) { bind<EditNoteInteractor>() }
}