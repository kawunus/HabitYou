package com.kawunus.habityou.di

import com.kawunus.habityou.ui.diary.viewmodel.DiaryViewModel
import com.kawunus.habityou.ui.editnote.viewmodel.EditNoteViewModel
import com.kawunus.habityou.ui.newnote.viewmodel.NewNoteViewModel
import com.kawunus.habityou.ui.root.viewmodel.ToolbarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::DiaryViewModel)

    viewModelOf(::ToolbarViewModel)

    viewModelOf(::NewNoteViewModel)

    viewModelOf(::EditNoteViewModel)
}