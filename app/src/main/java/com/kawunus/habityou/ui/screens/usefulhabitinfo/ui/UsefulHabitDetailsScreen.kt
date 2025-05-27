package com.kawunus.habityou.ui.screens.usefulhabitinfo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.ui.screens.usefulhabitinfo.viewmodel.UsefulHabitDetailsScreenState
import com.kawunus.habityou.ui.screens.usefulhabitinfo.viewmodel.UsefulHabitDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsefulHabitDetailsScreen(
    navController: NavController
) {
    val viewModel = koinViewModel<UsefulHabitDetailsViewModel>()
    val state by viewModel.state.collectAsState()

    val habit = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<UsefulHabit>("habit") ?: error("БЛЯТЬ НЕ МОЖЕТ ПРИВЫЧКА БЫТЬ NULL")

    LaunchedEffect(viewModel) {
        viewModel.getData(habit)
    }
    when (state) {
        is UsefulHabitDetailsScreenState.Content -> {
            val content = (state as UsefulHabitDetailsScreenState.Content)
            UsefulHabitDetailsContent(
                habitName = content.habitName,
                frequency = stringResource(content.frequencyResId),
                score = content.score,
                streak = content.streak,
                longestStreak = content.longestStreak,
                startedAt = content.startedAt,
                total = content.total,
                onEditClick = { },
                onDeleteClick = { }
            )
        }

        UsefulHabitDetailsScreenState.Loading -> {

        }

        UsefulHabitDetailsScreenState.Deleted -> {
            navController.popBackStack()
        }
    }
}
