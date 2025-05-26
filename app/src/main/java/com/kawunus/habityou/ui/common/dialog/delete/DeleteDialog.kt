package com.kawunus.habityou.ui.common.dialog.delete

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


/**
 * A composable function that displays a confirmation dialog for deleting an item.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the dialog.
 * @param titleResId A string resource ID for the dialog's title, typically describing the item to be deleted.
 * @param onDismiss A callback invoked when the dialog is dismissed without confirming the action.
 * @param onConfirm A callback invoked when the delete action is confirmed.
 *
 * This dialog is typically used to confirm irreversible delete actions, with options to cancel or proceed.
 */
@Composable
fun DeleteDialog(
    modifier: Modifier = Modifier,
    @StringRes
    titleResId: Int,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                Icons.Filled.Delete,
                contentDescription = stringResource(R.string.delete_icon_description)
            )
        },
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