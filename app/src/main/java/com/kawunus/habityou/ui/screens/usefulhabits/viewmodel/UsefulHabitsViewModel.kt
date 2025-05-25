package com.kawunus.habityou.ui.screens.usefulhabits.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.habityou.domain.api.usecase.CalculateScoreUseCase
import com.kawunus.habityou.domain.api.usecase.CalculateStreaksUseCase
import com.kawunus.habityou.domain.api.usecase.GetUsefulHabitsWithEntriesUseCase
import com.kawunus.habityou.domain.api.usecase.NewEntryUseCase
import com.kawunus.habityou.domain.model.Entry
import kotlinx.coroutines.launch
import java.time.Clock
import java.time.LocalDate

class UsefulHabitsViewModel(
    private val newEntry: NewEntryUseCase,
    private val calculateStreaks: CalculateStreaksUseCase,
    private val calculateScore: CalculateScoreUseCase,
    private val clock: Clock,
    private val getUsefulHabitsWithEntries: GetUsefulHabitsWithEntriesUseCase
) : ViewModel() {


    fun toggleEntry(habitId: Int, date: LocalDate) {
        viewModelScope.launch {
            newEntry(Entry(habitId = habitId, date = date))
        }
    }
}