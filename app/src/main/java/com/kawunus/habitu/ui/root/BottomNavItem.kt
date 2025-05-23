package com.kawunus.habitu.ui.root

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kawunus.habitu.R

sealed class BottomNavItem(
    val route: String, @StringRes val titleResId: Int, @DrawableRes val iconResId: Int
) {

    object BadHabits : BottomNavItem("bad_habit", R.string.bad_habits, R.drawable.ic_smoke)

    object UsefulHabits : BottomNavItem("useful_habit", R.string.useful_habits, R.drawable.ic_heart)

    object Diary : BottomNavItem("diary", R.string.diary, R.drawable.ic_diary)

    companion object {
        val items = listOf(BadHabits, UsefulHabits, Diary)
    }
}
