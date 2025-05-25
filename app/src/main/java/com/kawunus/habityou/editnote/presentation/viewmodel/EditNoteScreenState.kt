package com.kawunus.habityou.editnote.presentation.viewmodel

sealed class EditNoteScreenState {

    object Edited : EditNoteScreenState()

    object ReadyToEdit : EditNoteScreenState()

    object Deleted : EditNoteScreenState()
}