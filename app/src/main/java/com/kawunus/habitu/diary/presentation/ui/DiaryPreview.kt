package com.kawunus.habitu.diary.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kawunus.habitu.diary.domain.model.Note

@Preview(showBackground = true)
@Composable
private fun DiaryScreenPreview_Loading() {
    DiaryLoading()
}

@Preview(showBackground = true)
@Composable
private fun DiaryScreenPreview_Empty() {
    DiaryEmpty(onFabClick = {})
}

@Preview(showBackground = true)
@Composable
private fun DiaryScreenPreview_Content() {
    DiaryContent(
        notesList = listOf(
            Note(id = 1, title = "Test 1", content = "Text...", date = 123456789),
            Note(id = 2, title = "Test 2", content = "Another one", date = 13032923)
        ), onNoteEditClick = {}, onNoteDeleteClick = {}, onFabClick = {})
}

@Preview
@Composable
private fun PreviewNoteItem() {
    NoteItem(
        Note(
            id = 0, content = "Some content", date = 12345679, title = "Youuuuu"
        ),
        onEditClick = {

        },
        onDeleteClick = {

        }
    )
}