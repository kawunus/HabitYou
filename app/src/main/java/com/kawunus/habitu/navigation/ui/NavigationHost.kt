package com.kawunus.habitu.navigation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kawunus.habitu.navigation.model.BottomNavItem
import com.kawunus.habitu.newnote.presentation.NewNoteScreen
import com.kawunus.habitu.notes.presentation.ui.DiaryScreen
import com.kawunus.habitu.ui.root.BadHabitsScreen
import com.kawunus.habitu.ui.root.UsefulHabitsScreen

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