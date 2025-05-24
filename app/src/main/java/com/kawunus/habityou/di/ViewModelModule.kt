package com.kawunus.habityou.di

import com.kawunus.habityou.newnote.presentation.viewmodel.NewNoteViewModel
import com.kawunus.habityou.notes.presentation.viewmodel.DiaryViewModel
import com.kawunus.habityou.ui.root.ToolbarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::DiaryViewModel)

    viewModelOf(::ToolbarViewModel)

    viewModelOf(::NewNoteViewModel)
}