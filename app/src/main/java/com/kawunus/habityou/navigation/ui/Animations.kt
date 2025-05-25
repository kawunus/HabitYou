package com.kawunus.habityou.navigation.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

private const val TransitionDuration = 300

fun materialEnterTransition(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { it }, animationSpec = tween(TransitionDuration)
    ) + fadeIn(animationSpec = tween(TransitionDuration))
}

fun materialExitTransition(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { -it }, animationSpec = tween(TransitionDuration)
    ) + fadeOut(animationSpec = tween(TransitionDuration))
}

fun materialPopEnterTransition(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { -it }, animationSpec = tween(TransitionDuration)
    ) + fadeIn(animationSpec = tween(TransitionDuration))
}

fun materialPopExitTransition(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { it }, animationSpec = tween(TransitionDuration)
    ) + fadeOut(animationSpec = tween(TransitionDuration))
}