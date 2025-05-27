package com.kawunus.habityou.ui.common.navigation.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kawunus.habityou.ui.common.navigation.model.BottomNavItem
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.EDIT_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_NOTE_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.NEW_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.UPDATE_USEFUL_HABIT_ROUTE
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants.USEFUL_HABIT_DETAILS_ROUTE
import com.kawunus.habityou.ui.screens.badhabits.ui.BadHabitsScreen
import com.kawunus.habityou.ui.screens.diary.ui.DiaryScreen
import com.kawunus.habityou.ui.screens.editnote.ui.EditNoteScreen
import com.kawunus.habityou.ui.screens.newnote.ui.NewNoteScreen
import com.kawunus.habityou.ui.screens.newusefulhabit.ui.NewUsefulHabitScreen
import com.kawunus.habityou.ui.screens.updateusefulhabit.ui.UpdateUsefulHabitScreen
import com.kawunus.habityou.ui.screens.usefulhabitinfo.ui.UsefulHabitDetailsScreen
import com.kawunus.habityou.ui.screens.usefulhabits.ui.UsefulHabitsScreen


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
            DiaryScreen(navController)
        }
        composable(BottomNavItem.BadHabits.route) {
            BadHabitsScreen(navController)
        }
        composable(BottomNavItem.UsefulHabits.route) {
            UsefulHabitsScreen(navController)
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
        composable(NEW_USEFUL_HABIT_ROUTE, enterTransition = {
            materialEnterTransition()
        }, exitTransition = {
            materialExitTransition()
        }, popEnterTransition = {
            materialPopEnterTransition()
        }, popExitTransition = {
            materialPopExitTransition()
        }) {
            NewUsefulHabitScreen(navController = navController)
        }
        composable(UPDATE_USEFUL_HABIT_ROUTE, enterTransition = {
            materialEnterTransition()
        }, exitTransition = {
            materialExitTransition()
        }, popEnterTransition = {
            materialPopEnterTransition()
        }, popExitTransition = {
            materialPopExitTransition()
        }) {
            UpdateUsefulHabitScreen(navController = navController)
        }
        composable(USEFUL_HABIT_DETAILS_ROUTE, enterTransition = {
            materialEnterTransition()
        }, exitTransition = {
            materialExitTransition()
        }, popEnterTransition = {
            materialPopEnterTransition()
        }, popExitTransition = {
            materialPopExitTransition()
        }) {
            UsefulHabitDetailsScreen(navController = navController)
        }
    }
}


