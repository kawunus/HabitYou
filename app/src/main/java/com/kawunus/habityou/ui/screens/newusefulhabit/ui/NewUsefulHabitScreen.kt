package com.kawunus.habityou.ui.screens.newusefulhabit.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel.NewUsefulHabitScreenState
import com.kawunus.habityou.ui.screens.newusefulhabit.viewmodel.NewUsefulHabitViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewUsefulHabitScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf(UsefulHabitFrequency.DAILY) }

    val viewModel: NewUsefulHabitViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()

    when (state) {
        NewUsefulHabitScreenState.ReadyToCreate -> {

        }

        NewUsefulHabitScreenState.Created -> {
            navController.popBackStack()
        }
    }

    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.new_useful_habit_top_bar)) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_icon_description)
                    )
                }
            },
            actions = {
                TextButton(
                    onClick = {
                        if (title.isNotBlank()) {
                            viewModel.insertUsefulHabit(title, frequency)
                        }
                    }) {
                    Text(text = stringResource(R.string.new_item_save))
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
