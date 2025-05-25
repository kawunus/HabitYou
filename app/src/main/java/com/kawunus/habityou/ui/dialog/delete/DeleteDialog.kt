package com.kawunus.habityou.ui.dialog.delete

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.kawunus.habityou.R

@Composable
fun EditDeleteDialog(
    modifier: Modifier = Modifier,
    @StringRes
    titleResId: Int,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismiss,
        icon = { Icon(Icons.Filled.Delete, contentDescription = null) },
        title = { Text(text = stringResource(titleResId), textAlign = TextAlign.Center) },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.dialog_delete_cannot_undo),
                textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            Button(onClick = onConfirm) { Text(stringResource(R.string.dialog_delete_confirm)) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.dialog_delete_cancel))
            }
        }
    )
}