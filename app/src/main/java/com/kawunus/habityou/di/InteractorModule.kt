package com.kawunus.habityou.di

import com.kawunus.habityou.domain.api.usecase.CalculateScoreUseCase
import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.api.usecase.DiaryInteractor
import com.kawunus.habityou.domain.api.usecase.EditNoteInteractor
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.api.usecase.GetUsefulHabitsWithEntriesUseCase
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.api.usecase.NewNoteUseCase
import com.kawunus.habityou.domain.api.usecase.NewUsefulHabitUseCase
import com.kawunus.habityou.domain.usecase.CalculateScoreUseCaseImpl
import com.kawunus.habityou.domain.usecase.CalculateStreaksUseCaseImpl
import com.kawunus.habityou.domain.usecase.DiaryInteractorImpl
import com.kawunus.habityou.domain.usecase.EditNoteInteractorImpl
import com.kawunus.habityou.domain.usecase.GetEntriesUseCaseImpl
import com.kawunus.habityou.domain.usecase.GetUsefulHabitsWithEntriesUseCaseImpl
import com.kawunus.habityou.domain.usecase.NewEntryUseCaseImpl
import com.kawunus.habityou.domain.usecase.NewNoteUseCaseImpl
import com.kawunus.habityou.domain.usecase.NewUsefulHabitUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val interactorModule = module {

    singleOf(::DiaryInteractorImpl) { bind<DiaryInteractor>() }

    singleOf(::NewNoteUseCaseImpl) { bind<NewNoteUseCase>() }

    singleOf(::EditNoteInteractorImpl) { bind<EditNoteInteractor>() }

    singleOf(::NewEntryUseCaseImpl) { bind<NewEntryUseCase>() }

    singleOf(::GetEntriesUseCaseImpl) { bind<GetEntriesUseCase>() }

    singleOf(::CalculateStreaksUseCaseImpl) { bind<CalculateStreaksUseCase>() }

    singleOf(::CalculateScoreUseCaseImpl) { bind<CalculateScoreUseCase>() }

    singleOf(::GetUsefulHabitsWithEntriesUseCaseImpl) { bind<GetUsefulHabitsWithEntriesUseCase>() }

    singleOf(::NewUsefulHabitUseCaseImpl) { bind<NewUsefulHabitUseCase>() }
}