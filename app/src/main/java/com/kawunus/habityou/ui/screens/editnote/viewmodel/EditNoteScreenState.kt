package com.kawunus.habityou.ui.screens.editnote.viewmodel

sealed class EditNoteScreenState {

    object Edited : EditNoteScreenState()

    object ReadyToEdit : EditNoteScreenState()

    object Deleted : EditNoteScreenState()
}