package com.kawunus.habityou.ui.screens.editnote.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun EditNoteScreenPreview() {
    EditNoteScreen(
        navController = rememberNavController()
    )
}