package com.kawunus.habityou.di

import com.kawunus.habityou.editnote.domain.api.EditNoteUseCase
import com.kawunus.habityou.editnote.domain.impl.EditNoteUseCaseImpl
import com.kawunus.habityou.newnote.domain.api.NewNoteUseCase
import com.kawunus.habityou.newnote.domain.impl.NewNoteUseCaseImpl
import com.kawunus.habityou.notes.domain.api.DiaryInteractor
import com.kawunus.habityou.notes.domain.impl.DiaryInteractorImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::DiaryInteractorImpl) { bind<DiaryInteractor>() }

    singleOf(::NewNoteUseCaseImpl) { bind<NewNoteUseCase>() }

    singleOf(::EditNoteUseCaseImpl) { bind<EditNoteUseCase>() }
}