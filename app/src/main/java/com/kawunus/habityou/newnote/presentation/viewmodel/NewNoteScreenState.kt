package com.kawunus.habityou.newnote.presentation.viewmodel

sealed class NewNoteScreenState {

    object Done : NewNoteScreenState()

    object ReadyToCreate : NewNoteScreenState()
}