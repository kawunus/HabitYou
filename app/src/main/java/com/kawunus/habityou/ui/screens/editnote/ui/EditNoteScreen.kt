package com.kawunus.habityou.ui.screens.editnote.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.Note
import com.kawunus.habityou.ui.common.dialog.delete.DeleteDialog
import com.kawunus.habityou.ui.screens.editnote.viewmodel.EditNoteScreenState
import com.kawunus.habityou.ui.screens.editnote.viewmodel.EditNoteViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteScreen(
    navController: NavController,
) {

    val viewModel = koinViewModel<EditNoteViewModel>()
    val state by viewModel.state.collectAsState()

    val note = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<Note>("note")

    var deleteDialogOpen by remember { mutableStateOf(false) }

    when (state) {
        EditNoteScreenState.Edited -> {
            navController.popBackStack()
        }

        EditNoteScreenState.ReadyToEdit -> {

        }

        EditNoteScreenState.Deleted -> {
            navController.popBackStack()
        }
    }

    var title by remember { mutableStateOf(note?.title ?: "") }
    var content by remember { mutableStateOf(note?.content ?: "") }


    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.new_note_top_bar)) },
            actions = {
                TextButton(
                    onClick = {
                        if (title.isNotBlank() && content.isNotBlank()) {
                            viewModel.editNote(
                                note?.copy(
                                    title = title,
                                    content = content
                                ) ?: error("note is null!")
                            )
                        }
                    }) {
                    Text(text = stringResource(R.string.new_item_save))
                }
                IconButton(onClick = {
                    deleteDialogOpen = true
                }) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.delete_icon_description)
                    )
                }
            })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = stringResource(R.string.new_note_title)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = stringResource(R.string.new_note_description)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            maxLines = 10
        )
    }

    if (deleteDialogOpen) {
        DeleteDialog(
            titleResId = R.string.dialog_delete_title_note,
            onConfirm = {
                viewModel.deleteNote(note ?: return@DeleteDialog)
                deleteDialogOpen = false
            },
            onDismiss = { deleteDialogOpen = false }
        )
    }
}