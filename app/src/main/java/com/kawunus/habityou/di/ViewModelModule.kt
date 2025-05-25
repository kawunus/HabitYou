package com.kawunus.habityou.di

import com.kawunus.habityou.ui.screens.diary.viewmodel.DiaryViewModel
import com.kawunus.habityou.ui.screens.editnote.viewmodel.EditNoteViewModel
import com.kawunus.habityou.ui.screens.newnote.viewmodel.NewNoteViewModel
import com.kawunus.habityou.ui.screens.root.viewmodel.ToolbarViewModel
import com.kawunus.habityou.ui.screens.usefulhabits.viewmodel.UsefulHabitsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::DiaryViewModel)

    viewModelOf(::ToolbarViewModel)

    viewModelOf(::NewNoteViewModel)

    viewModelOf(::EditNoteViewModel)

    viewModelOf(::UsefulHabitsViewModel)
}