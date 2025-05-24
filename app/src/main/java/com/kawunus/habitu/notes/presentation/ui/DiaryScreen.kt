package com.kawunus.habitu.notes.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.kawunus.habitu.navigation.model.NavigationConstants
import com.kawunus.habitu.notes.presentation.viewmodel.DiaryScreenState
import com.kawunus.habitu.notes.presentation.viewmodel.DiaryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun DiaryScreen(navController: NavController) {
    val viewModel: DiaryViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getData()
    }

    Scaffold(
        floatingActionButton = {
            if (state !is DiaryScreenState.Loading) {
                FloatingActionButton(onClick = { navController.navigate(NavigationConstants.NEW_NOTE_ROUTE) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
                }
            }
        }) {
        when (state) {
            is DiaryScreenState.Content -> {
                DiaryContent(
                    notesList = (state as DiaryScreenState.Content).content,
                    onNoteEditClick = { note ->
                        // TODO: handle edit
                    },
                    onNoteDeleteClick = { note ->
                        viewModel.deleteNote(note)
                    })
            }

            DiaryScreenState.Empty -> {
                DiaryEmpty()
            }

            DiaryScreenState.Loading -> {
                DiaryLoading()
            }
        }
    }
}