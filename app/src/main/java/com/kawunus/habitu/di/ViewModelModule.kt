package com.kawunus.habitu.di

import com.kawunus.habitu.notes.presentation.viewmodel.DiaryViewModel
import com.kawunus.habitu.ui.root.ToolbarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::DiaryViewModel)

    viewModelOf(::ToolbarViewModel)
}