package com.kawunus.habityou.navigation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kawunus.habityou.R
import com.kawunus.habityou.navigation.model.NavigationConstants.BAD_HABITS_ROUTE
import com.kawunus.habityou.navigation.model.NavigationConstants.DIARY_ROUTE
import com.kawunus.habityou.navigation.model.NavigationConstants.USEFUL_HABITS_ROUTE

sealed class BottomNavItem(
    val route: String, @StringRes val titleResId: Int, @DrawableRes val iconResId: Int
) {

    object BadHabits : BottomNavItem(BAD_HABITS_ROUTE, R.string.bad_habits, R.drawable.ic_smoke)

    object UsefulHabits :
        BottomNavItem(USEFUL_HABITS_ROUTE, R.string.useful_habits, R.drawable.ic_heart)

    object Diary : BottomNavItem(DIARY_ROUTE, R.string.diary, R.drawable.ic_diary)

    companion object {
        val items = listOf(BadHabits, UsefulHabits, Diary)
    }
}