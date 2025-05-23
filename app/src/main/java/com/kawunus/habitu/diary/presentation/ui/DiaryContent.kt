package com.kawunus.habitu.diary.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kawunus.habitu.diary.domain.model.Note

@Composable
internal fun DiaryContent(
    notesList: List<Note>,
    modifier: Modifier = Modifier,
    onEditClick: (Note) -> Unit,
    onDeleteClick: (Note) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(notesList) { index, note ->
            NoteItem(
                note = note,
                onEditClick = { onEditClick(note) },
                onDeleteClick = { onDeleteClick(note) })
        }
    }
}