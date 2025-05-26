package com.kawunus.habityou.ui.common.usefulhabit

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabitFrequency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsefulHabitEditForm(
    initialTitle: String,
    initialFrequency: UsefulHabitFrequency,
    onSaveClick: (title: String, frequency: UsefulHabitFrequency) -> Unit,
    @StringRes topBarTitleRes: Int,
    isDeleteIconVisible: Boolean = false,
    onDeleteClick: () -> Unit = {},
) {
    var title by remember { mutableStateOf(initialTitle) }
    var frequency by remember { mutableStateOf(initialFrequency) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(text = stringResource(topBarTitleRes)) }, actions = {
            TextButton(
                onClick = {
                    if (title.isNotBlank()) {
                        onSaveClick(title, frequency)
                    }
                }) {
                Text(text = stringResource(R.string.new_item_save))
            }
            if (isDeleteIconVisible) {
                IconButton(onClick = {
                    onDeleteClick()
                }) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.delete_icon_description)
                    )
                }
            }
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = stringResource(R.string.new_useful_habit_title)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        HabitFrequencyDropdown(
            selectedFrequency = frequency,
            onFrequencyChange = { frequency = it },
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HabitFrequencyDropdown(
    modifier: Modifier = Modifier,
    selectedFrequency: UsefulHabitFrequency,
    onFrequencyChange: (UsefulHabitFrequency) -> Unit
) {
    val frequencyOptions = UsefulHabitFrequency.entries
    var frequencyExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = frequencyExpanded,
        onExpandedChange = { frequencyExpanded = !frequencyExpanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            readOnly = true,
            value = stringResource(id = selectedFrequency.userReadableStringRes),
            onValueChange = {},
            label = { Text(stringResource(R.string.useful_habit_frequency)) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = frequencyExpanded) },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
        )

        ExposedDropdownMenu(
            expanded = frequencyExpanded,
            onDismissRequest = { frequencyExpanded = false },
        ) {
            frequencyOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(stringResource(id = option.userReadableStringRes)) },
                    onClick = {
                        onFrequencyChange(option)
                        frequencyExpanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsefulHabitEditFormPreview() {
    UsefulHabitEditForm(
        initialTitle = "",
        initialFrequency = UsefulHabitFrequency.DAILY,
        onSaveClick = { _, _ -> },
        topBarTitleRes = R.string.new_useful_habit_top_bar,
    )
}

