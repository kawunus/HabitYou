package com.kawunus.habityou.ui.screens.usefulhabits.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kawunus.habityou.R
import com.kawunus.habityou.ui.common.hint.FullscreenHint

@Composable
internal fun UsefulHabitsEmpty(modifier: Modifier = Modifier) {
    FullscreenHint(
        modifier = modifier
            .fillMaxSize(),
        icon = Icons.Default.Add,
        iconContentDescription = R.string.add_icon_description,
        text = R.string.useful_habits_empty
    )
}