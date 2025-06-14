package com.kawunus.habityou.ui.screens.diary.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.ui.common.dialog.delete.DeleteDialog
import com.kawunus.habityou.ui.common.navigation.model.NavigationConstants
import com.kawunus.habityou.ui.screens.diary.viewmodel.DiaryScreenState
import com.kawunus.habityou.ui.screens.diary.viewmodel.DiaryViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(navController: NavController) {
    val viewModel: DiaryViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    var deleteDialogOpen by remember { mutableStateOf(false) }
    var currentNote by remember { mutableStateOf<Note?>(null) }

    LaunchedEffect(viewModel) {
        viewModel.getData()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.diary)) },
            )
        },
        floatingActionButton = {
            if (state !is DiaryScreenState.Loading) {
                FloatingActionButton(onClick = { navController.navigate(NavigationConstants.NEW_NOTE_ROUTE) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
                }
            }
        }) { paddingValues ->
        when (state) {
            is DiaryScreenState.Content -> {
                DiaryContent(
                    notesList = (state as DiaryScreenState.Content).content,
                    modifier = Modifier.padding(paddingValues),
                    onNoteEditClick = { note ->
                        navController.currentBackStackEntry?.savedStateHandle?.set("note", note)
                        navController.navigate(NavigationConstants.EDIT_NOTE_ROUTE)
                    },
                    onNoteDeleteClick = { note ->
                        deleteDialogOpen = true
                        currentNote = note
                    })

                if (deleteDialogOpen) {
                    DeleteDialog(
                        titleResId = R.string.dialog_delete_title_note,
                        onDismiss = {
                            deleteDialogOpen = false
                            currentNote = null
                        },
                        onConfirm = {
                            deleteDialogOpen = false
                            viewModel.deleteNote(currentNote ?: return@DeleteDialog)
                            currentNote = null
                        }
                    )
                }
            }

            DiaryScreenState.Empty -> {
                DiaryEmpty(modifier = Modifier.padding(paddingValues))
            }

            DiaryScreenState.Loading -> {
                DiaryLoading(modifier = Modifier.padding(paddingValues))
            }
        }
    }
}