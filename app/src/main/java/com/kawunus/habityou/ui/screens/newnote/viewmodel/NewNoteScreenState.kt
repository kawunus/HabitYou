package com.kawunus.habityou.ui.screens.newnote.viewmodel

sealed class NewNoteScreenState {

    object Done : NewNoteScreenState()

    object ReadyToCreate : NewNoteScreenState()
}