package com.kawunus.habityou.ui.screens.usefulhabitinfo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.ui.common.dialog.delete.DeleteDialog
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.UPDATE_USEFUL_HABIT_ROUTE
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
        ?.get<UsefulHabit>("habit")

    LaunchedEffect(viewModel) {
        viewModel.getData(habit)
    }

    var deleteDialogOpen by remember { mutableStateOf(false) }

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
                onEditClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("habit", habit)
                    navController.navigate(UPDATE_USEFUL_HABIT_ROUTE)
                },
                onDeleteClick = {
                    deleteDialogOpen = true
                }
            )
        }

        UsefulHabitDetailsScreenState.Loading -> {

        }

        UsefulHabitDetailsScreenState.Deleted -> {
            navController.popBackStack()
        }
    }

    if (deleteDialogOpen) {
        DeleteDialog(
            titleResId = R.string.dialog_delete_title_habit,
            onConfirm = {
                viewModel.deleteHabit(habit)
                deleteDialogOpen = false
            },
            onDismiss = { deleteDialogOpen = false }
        )
    }
}
