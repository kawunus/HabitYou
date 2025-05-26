package com.kawunus.habityou.ui.screens.updateusefulhabit.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import com.kawunus.habityou.ui.common.dialog.delete.DeleteDialog
import com.kawunus.habityou.ui.common.usefulhabit.UsefulHabitEditForm
import com.kawunus.habityou.ui.screens.updateusefulhabit.viewmodel.UpdateUsefulHabitScreenState
import com.kawunus.habityou.ui.screens.updateusefulhabit.viewmodel.UpdateUsefulHabitViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UpdateUsefulHabitScreen(navController: NavController) {

    val viewModel = koinViewModel<UpdateUsefulHabitViewModel>()
    val state by viewModel.state.collectAsState()

    val habit = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<UsefulHabit>("habit")

    var deleteDialogOpen by remember { mutableStateOf(false) }

    when (state) {
        UpdateUsefulHabitScreenState.Updated -> {
            navController.popBackStack()
        }

        UpdateUsefulHabitScreenState.ReadyToUpdate -> {

        }

        UpdateUsefulHabitScreenState.Deleted -> {
            navController.popBackStack()
        }
    }

    var title = habit?.name ?: ""
    var type = habit?.type ?: UsefulHabitFrequency.DAILY

    UsefulHabitEditForm(
        initialTitle = title,
        initialFrequency = type,
        onSaveClick = { title, frequency ->
            viewModel.updateHabit(
                habit?.copy(
                    name = title,
                    type = frequency
                ) ?: return@UsefulHabitEditForm
            )
        },
        topBarTitleRes = R.string.update_useful_habit_top_bar,
        isDeleteIconVisible = true,
        onDeleteClick = {
            deleteDialogOpen = true
        }
    )
    if (deleteDialogOpen) {
        DeleteDialog(
            titleResId = R.string.dialog_delete_title_habit,
            onConfirm = {
                viewModel.deleteHabit(habit ?: return@DeleteDialog)
                deleteDialogOpen = false
            },
            onDismiss = { deleteDialogOpen = false }
        )
    }


}