package com.kawunus.habitu.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kawunus.habitu.newnote.presentation.NewNoteScreen
import com.kawunus.habitu.notes.presentation.ui.DiaryScreen
import org.koin.compose.koinInject

@ExperimentalMaterial3Api
@Preview
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val toolbarViewModel: ToolbarViewModel = koinInject()

    val title by toolbarViewModel.title.collectAsState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Список экранов, где нужно скрывать AppBar и BottomBar
    val hideBarsRoutes = listOf("newNote")
    val shouldShowBars = currentRoute !in hideBarsRoutes

    LaunchedEffect(currentRoute) {
        when (currentRoute) {
            BottomNavItem.Diary.route -> toolbarViewModel.setTitle("Личный дневник")
            BottomNavItem.BadHabits.route -> toolbarViewModel.setTitle("Вредные привычки")
            BottomNavItem.UsefulHabits.route -> toolbarViewModel.setTitle("Полезные привычки")
            else -> toolbarViewModel.setTitle("Habitu")
        }
    }

    Scaffold(
        bottomBar = {
            if (shouldShowBars) {
                BottomNavigationBar(navController = navController)
            }
        },
        topBar = {
            if (shouldShowBars) {
                TopAppBar(
                    title = { Text(text = title) },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Настройки"
                            )
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.BadHabits.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Diary.route) {
                DiaryScreen(navController = navController)
            }
            composable(BottomNavItem.BadHabits.route) {
                BadHabitsScreen()
            }
            composable(BottomNavItem.UsefulHabits.route) {
                UsefulHabitsScreen()
            }
            composable("newNote") {
                NewNoteScreen(navController = navController)
            }
        }
    }
}


@Composable
fun BadHabitsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Вредные привычки")
    }
}

@Composable
fun UsefulHabitsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Полезные привычки")
    }
}
