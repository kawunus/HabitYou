package com.kawunus.habityou.ui.screens.updateusefulhabit.viewmodel

sealed class UpdateUsefulHabitScreenState {

    object ReadyToUpdate : UpdateUsefulHabitScreenState()

    object Deleted : UpdateUsefulHabitScreenState()

    object Updated : UpdateUsefulHabitScreenState()
}