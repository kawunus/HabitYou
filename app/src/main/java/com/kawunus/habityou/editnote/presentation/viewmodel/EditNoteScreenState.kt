package com.kawunus.habityou.editnote.presentation.viewmodel

sealed class EditNoteScreenState {

    object Done : EditNoteScreenState()

    object ReadyToEdit : EditNoteScreenState()
}