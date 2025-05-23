package com.kawunus.habitu.diary.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kawunus.habitu.diary.domain.model.Note

@Composable
internal fun DiaryContent(
    notesList: List<Note>,
    onNoteEditClick: (Note) -> Unit,
    onNoteDeleteClick: (Note) -> Unit,
    onFabClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {

            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            itemsIndexed(notesList) { _, note ->
                NoteItem(
                    note = note,
                    onEditClick = { onNoteEditClick(note) },
                    onDeleteClick = { onNoteDeleteClick(note) }
                )
            }
        }
    }
}
