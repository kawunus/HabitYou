package com.kawunus.habityou.ui.screens.newnote.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun NewNoteScreenPreview() {
    NewNoteScreen(
        navController = rememberNavController()
    )
}