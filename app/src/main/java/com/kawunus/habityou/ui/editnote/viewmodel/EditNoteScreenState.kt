package com.kawunus.habityou.ui.editnote.viewmodel

sealed class EditNoteScreenState {

    object Edited : EditNoteScreenState()

    object ReadyToEdit : EditNoteScreenState()

    object Deleted : EditNoteScreenState()
}