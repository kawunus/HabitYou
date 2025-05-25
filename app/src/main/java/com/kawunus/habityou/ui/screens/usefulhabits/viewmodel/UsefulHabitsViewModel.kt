package com.kawunus.habityou.ui.screens.usefulhabits.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.model.Entry
import kotlinx.coroutines.launch
import java.time.LocalDate

class UsefulHabitsViewModel(
    private val newEntryUseCase: NewEntryUseCase
) : ViewModel() {


    fun toggleEntry(habitId: Int, date: LocalDate) {
        viewModelScope.launch {
            newEntryUseCase.invoke(Entry(habitId = habitId, date = date))
        }
    }
}