package com.kawunus.habityou.navigation.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kawunus.habityou.editnote.presentation.ui.EditNoteScreen
import com.kawunus.habityou.navigation.model.BottomNavItem
import com.kawunus.habityou.navigation.model.NavigationConstants.EDIT_NOTE_ROUTE
import com.kawunus.habityou.navigation.model.NavigationConstants.NEW_NOTE_ROUTE
import com.kawunus.habityou.newnote.presentation.ui.NewNoteScreen
import com.kawunus.habityou.notes.presentation.ui.DiaryScreen
import com.kawunus.habityou.ui.root.BadHabitsScreen
import com.kawunus.habityou.ui.root.UsefulHabitsScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController, startDestination = startDestination, modifier = modifier
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
        composable(NEW_NOTE_ROUTE, enterTransition = {
            materialEnterTransition()
        }, exitTransition = {
            materialExitTransition()
        }, popEnterTransition = {
            materialPopEnterTransition()
        }, popExitTransition = {
            materialPopExitTransition()
        }) {
            NewNoteScreen(navController = navController)
        }
        composable(EDIT_NOTE_ROUTE, enterTransition = {
            materialEnterTransition()
        }, exitTransition = {
            materialExitTransition()
        }, popEnterTransition = {
            materialPopEnterTransition()
        }, popExitTransition = {
            materialPopExitTransition()
        }) {
            EditNoteScreen(navController = navController)
        }
    }
}


