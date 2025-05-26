package com.kawunus.habityou.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kawunus.habityou.ui.common.navigation.model.BottomNavItem
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.EDIT_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.UPDATE_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.common.navigation.ui.BottomNavigationBar
import com.kawunus.habityou.ui.common.navigation.ui.NavigationHost
import com.kawunus.habityou.ui.theme.HabituTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabituTheme {
                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val hideBottomBarRoutes =
                    listOf(
                        NEW_NOTE_ROUTE,
                        EDIT_NOTE_ROUTE,
                        NEW_USEFUL_HABIT_ROUTE,
                        UPDATE_USEFUL_HABIT_ROUTE
                    )

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
        }
    }
}