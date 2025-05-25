package com.kawunus.habityou.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kawunus.habityou.R
import com.kawunus.habityou.navigation.model.BottomNavItem
import com.kawunus.habityou.navigation.model.NavigationConstants
import com.kawunus.habityou.navigation.model.NavigationConstants.EDIT_NOTE_ROUTE
import com.kawunus.habityou.navigation.model.NavigationConstants.NEW_NOTE_ROUTE
import com.kawunus.habityou.navigation.ui.BottomNavigationBar
import com.kawunus.habityou.navigation.ui.NavigationHost
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val toolbarViewModel: ToolbarViewModel = koinInject()
    val title by toolbarViewModel.titleStringRes.collectAsState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val hideTopBarRoutes = listOf(NEW_NOTE_ROUTE, EDIT_NOTE_ROUTE)
    val hideBottomBarRoutes = listOf(NEW_NOTE_ROUTE, EDIT_NOTE_ROUTE)

    val showTopBar = currentRoute !in hideTopBarRoutes
    val showBottomBar = currentRoute !in hideBottomBarRoutes

    LaunchedEffect(currentRoute) {
        when (currentRoute) {
            NavigationConstants.DIARY_ROUTE -> toolbarViewModel.setTitleStringRes(R.string.diary)
            NavigationConstants.BAD_HABITS_ROUTE -> toolbarViewModel.setTitleStringRes(R.string.bad_habits)
            NavigationConstants.USEFUL_HABITS_ROUTE -> toolbarViewModel.setTitleStringRes(R.string.useful_habits)
        }
    }

    Scaffold(contentWindowInsets = WindowInsets(0), topBar = {
        if (showTopBar) {
            TopAppBar(title = { Text(text = stringResource(title)) }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = stringResource(R.string.settings_icon_description)
                    )
                }
            })
        }
    }, bottomBar = {
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


@Composable
fun BadHabitsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.bad_habits))
    }
}

@Composable
fun UsefulHabitsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.useful_habits))
    }
}
