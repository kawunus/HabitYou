package com.kawunus.habityou.ui.screens.usefulhabits.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.ui.common.dialog.delete.DeleteDialog
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.screens.usefulhabits.viewmodel.UsefulHabitsScreenState
import com.kawunus.habityou.ui.screens.usefulhabits.viewmodel.UsefulHabitsViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsefulHabitsScreen(navController: NavController) {
    val viewModel: UsefulHabitsViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    var deleteDialogOpen by remember { mutableStateOf(false) }
    var currentHabit by remember { mutableStateOf<UsefulHabit?>(null) }

    LaunchedEffect(viewModel) {
        viewModel.getData()
    }

    Scaffold(floatingActionButton = {
        if (state !is UsefulHabitsScreenState.Loading) {
            FloatingActionButton(onClick = { navController.navigate(NEW_USEFUL_HABIT_ROUTE) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        }
    }, topBar = {
        TopAppBar(title = {
            Text(text = stringResource(R.string.useful_habits))
        })
    }) { paddingValues ->
        when (state) {
            is UsefulHabitsScreenState.Content -> {
                val content = state as UsefulHabitsScreenState.Content
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    items(content.usefulHabits) { habit ->
                        UsefulHabitCard(
                            usefulHabit = habit,
                            completedOnClick = { id, date ->
                                viewModel.toggleEntry(id, date)
                            },
                            showStatistic = content.showStreaks || content.showScore,
                            todaysDate = content.todaysDate,
                            onDeleteIconClick = { habit ->
                                deleteDialogOpen = true
                                currentHabit = habit
                            },
                            onEditIconClick = { habit ->
                            },
                            onMoreIconClick = { habit ->
                            }
                        )
                    }
                }
            }

            UsefulHabitsScreenState.Empty -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(R.string.useful_habits_empty))
                }
            }

            UsefulHabitsScreenState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }
        }
        if (deleteDialogOpen) {
            DeleteDialog(
                titleResId = R.string.dialog_delete_title_habit,
                onDismiss = {
                    deleteDialogOpen = false
                    currentHabit = null
                },
                onConfirm = {
                    deleteDialogOpen = false
                    viewModel.deleteHabit(currentHabit?.id ?: return@DeleteDialog)
                    currentHabit = null
                })
        }
    }
}


