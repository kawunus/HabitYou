package com.kawunus.habityou.ui.screens.newusefulhabit.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import com.kawunus.habityou.ui.common.usefulhabit.UsefulHabitEditForm
import com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel.NewUsefulHabitScreenState
import com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel.NewUsefulHabitViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewUsefulHabitScreen(navController: NavController) {
    val viewModel: NewUsefulHabitViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    when (state) {
        NewUsefulHabitScreenState.ReadyToCreate -> Unit
        NewUsefulHabitScreenState.Created -> navController.popBackStack()
    }

    UsefulHabitEditForm(
        initialTitle = "",
        initialFrequency = UsefulHabitFrequency.DAILY,
        onSaveClick = { title, frequency ->
            viewModel.insertUsefulHabit(title, frequency)
        },
        topBarTitleRes = R.string.new_useful_habit_top_bar,
        isDeleteIconVisible = false,
        onDeleteClick = {}
    )
}
