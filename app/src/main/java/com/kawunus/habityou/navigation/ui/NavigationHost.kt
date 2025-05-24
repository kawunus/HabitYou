package com.kawunus.habityou.navigation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kawunus.habityou.navigation.model.BottomNavItem
import com.kawunus.habityou.newnote.presentation.NewNoteScreen
import com.kawunus.habityou.notes.presentation.ui.DiaryScreen
import com.kawunus.habityou.ui.root.BadHabitsScreen
import com.kawunus.habityou.ui.root.UsefulHabitsScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )
    {
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