package com.kawunus.habityou.ui.newnote.viewmodel

sealed class NewNoteScreenState {

    object Done : NewNoteScreenState()

    object ReadyToCreate : NewNoteScreenState()
}