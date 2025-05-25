package com.kawunus.habityou.ui.dialog.delete

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kawunus.habityou.R

@Preview
@Composable
private fun EditDeleteDialogPreview_Note() {
    EditDeleteDialog(
        titleResId = R.string.dialog_delete_title_note,
        onConfirm = {},
        onDismiss = {})
}

@Preview
@Composable
private fun EditDeleteDialogPreview_Habit() {
    EditDeleteDialog(
        titleResId = R.string.dialog_delete_title_habit,
        onConfirm = {},
        onDismiss = {})
}