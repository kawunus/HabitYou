package com.kawunus.habityou.ui.newnote.ui

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