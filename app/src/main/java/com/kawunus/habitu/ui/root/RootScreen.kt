package com.kawunus.habitu.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kawunus.habitu.diary.presentation.ui.DiaryScreen

@Preview
@Composable
fun RootScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.BadHabits.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Diary.route) { DiaryScreen() }
            composable(BottomNavItem.BadHabits.route) { BadHabitsScreen() }
            composable(BottomNavItem.UsefulHabits.route) { UsefulHabitsScreen() }
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
