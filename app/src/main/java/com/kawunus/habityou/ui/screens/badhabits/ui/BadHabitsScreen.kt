package com.kawunus.habityou.ui.screens.badhabits.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.kawunus.habityou.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadHabitsScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(R.string.bad_habits)) },
        )
    }) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center
        ) {
            Text(stringResource(R.string.bad_habits))
        }
    }
}
