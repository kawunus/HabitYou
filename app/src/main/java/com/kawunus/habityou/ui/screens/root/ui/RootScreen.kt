package com.kawunus.habityou.ui.screens.root.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kawunus.habityou.R
import com.kawunus.habityou.ui.common.navigation.model.BottomNavItem
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.EDIT_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.common.navigation.ui.BottomNavigationBar
import com.kawunus.habityou.ui.common.navigation.ui.NavigationHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val hideBottomBarRoutes = listOf(NEW_NOTE_ROUTE, EDIT_NOTE_ROUTE, NEW_USEFUL_HABIT_ROUTE)

    val showBottomBar = currentRoute !in hideBottomBarRoutes

    Scaffold(contentWindowInsets = WindowInsets(0), bottomBar = {
        if (showBottomBar) {
            BottomNavigationBar(navController = navController)
        }
    }) { innerPadding ->
        NavigationHost(
            navController = navController,
            startDestination = BottomNavItem.BadHabits.route,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadHabitsScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(R.string.bad_habits)) },
        )
    }) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center
        ) {
            Text(stringResource(R.string.bad_habits))
        }
    }
}
