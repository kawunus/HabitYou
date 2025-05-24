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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kawunus.habitu.navigation.model.BottomNavItem
import com.kawunus.habitu.navigation.model.NavigationConstants
import com.kawunus.habitu.navigation.ui.BottomNavigationBar
import com.kawunus.habitu.navigation.ui.NavigationHost
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

    val mainBarRoutes = listOf(
        NavigationConstants.DIARY_ROUTE,
        NavigationConstants.BAD_HABITS_ROUTE,
        NavigationConstants.USEFUL_HABITS_ROUTE
    )
    val shouldShowBars = currentRoute in mainBarRoutes

    LaunchedEffect(currentRoute) {
        when (currentRoute) {
            NavigationConstants.DIARY_ROUTE -> toolbarViewModel.setTitle("Личный дневник")
            NavigationConstants.BAD_HABITS_ROUTE -> toolbarViewModel.setTitle("Вредные привычки")
            NavigationConstants.USEFUL_HABITS_ROUTE -> toolbarViewModel.setTitle("Полезные привычки")
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
        NavigationHost(
            navController = navController,
            startDestination = BottomNavItem.BadHabits.route,
            modifier = Modifier.padding(innerPadding)
        )
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
