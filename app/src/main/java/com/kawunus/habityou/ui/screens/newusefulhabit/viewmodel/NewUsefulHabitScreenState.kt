package com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel

sealed class NewUsefulHabitScreenState {

    object ReadyToCreate : NewUsefulHabitScreenState()

    object Created : NewUsefulHabitScreenState()
}