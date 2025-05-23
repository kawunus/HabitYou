package com.kawunus.habitu.di

import com.kawunus.habitu.diary.presentation.viewmodel.DiaryViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::DiaryViewModel)

}