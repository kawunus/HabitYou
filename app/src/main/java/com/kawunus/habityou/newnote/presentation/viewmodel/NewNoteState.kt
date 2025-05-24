package com.kawunus.habityou.newnote.presentation.viewmodel

sealed class NewNoteState {

    object Done : NewNoteState()

    object ReadyToCreate : NewNoteState()
}