package com.kawunus.habitu.diary.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.kawunus.habitu.diary.presentation.viewmodel.DiaryScreenState
import com.kawunus.habitu.diary.presentation.viewmodel.DiaryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DiaryScreen() {
    val viewModel: DiaryViewModel = koinViewModel<DiaryViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getData()
    }
    Scaffold { innerPadding ->
        when (state) {
            is DiaryScreenState.Content -> {
                DiaryContent(
                    notesList = (state as DiaryScreenState.Content).content,
                    modifier = Modifier.padding(innerPadding),
                    onNoteEditClick = { note ->

                    },
                    onNoteDeleteClick = { note ->
                        viewModel.deleteNote(note)
                    },
                    onFabClick = {
                        viewModel.insertNote()
                    }
                )
            }

            DiaryScreenState.Empty -> {
                DiaryEmpty(
                    modifier = Modifier.padding(innerPadding),
                    onFabClick = { viewModel.insertNote() })
            }

            DiaryScreenState.Loading -> {
                DiaryLoading(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}


