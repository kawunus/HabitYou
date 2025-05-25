package com.kawunus.habityou.ui.screens.usefulhabits.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kawunus.habityou.ui.screens.usefulhabits.viewmodel.UsefulHabitsScreenState
import com.kawunus.habityou.ui.screens.usefulhabits.viewmodel.UsefulHabitsViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun UsefulHabitsScreen(navController: NavController) {
    val viewModel: UsefulHabitsViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getData()
    }

    Scaffold(
        floatingActionButton = {
            if (state !is UsefulHabitsScreenState.Loading) {
                FloatingActionButton(onClick = { viewModel.insertHabit() }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
                }
            }
        }
    ) {
        when (state) {
            is UsefulHabitsScreenState.Content -> {
                val content = state as UsefulHabitsScreenState.Content
                LazyColumn(modifier = Modifier) {
                    items(content.usefulHabits) { habit ->
                        UsefulHabitCard(
                            usefulHabit = habit,
                            completedOnClick = { id, date ->
                                viewModel.toggleEntry(id, date)
                            },
                            showStatistic = content.showStreaks || content.showScore,
                            todaysDate = content.todaysDate
                        )
                    }
                }
            }

            UsefulHabitsScreenState.Empty -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "У вас нет полезных привычек :(")
                }
            }

            UsefulHabitsScreenState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }
        }
    }
}