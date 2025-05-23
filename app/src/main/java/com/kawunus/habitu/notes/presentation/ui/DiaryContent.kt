package com.kawunus.habitu.notes.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kawunus.habitu.notes.domain.model.Note

@Composable
internal fun DiaryContent(
    notesList: List<Note>,
    onNoteEditClick: (Note) -> Unit,
    onNoteDeleteClick: (Note) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(notesList, key = { _, note -> note.id }) { _, note ->
            NoteItem(
                note = note,
                onEditClick = { onNoteEditClick(note) },
                onDeleteClick = { onNoteDeleteClick(note) },
                modifier = Modifier.animateItem()
            )
        }
    }
}

