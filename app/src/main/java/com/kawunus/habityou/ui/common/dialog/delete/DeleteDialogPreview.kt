package com.kawunus.habityou.ui.common.dialog.delete

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kawunus.habityou.R

@Preview
@Composable
private fun DeleteDialogPreview_Note() {
    DeleteDialog(
        titleResId = R.string.dialog_delete_title_note,
        onConfirm = {},
        onDismiss = {})
}

@Preview
@Composable
private fun DeleteDialogPreview_Habit() {
    DeleteDialog(
        titleResId = R.string.dialog_delete_title_habit,
        onConfirm = {},
        onDismiss = {})
}