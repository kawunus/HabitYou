package com.kawunus.habityou.ui.screens.usefulhabitinfo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsefulHabitDetailsScreen(
    habit: UsefulHabit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = habit.name) },
            actions = {
                IconButton(onClick = {/*TODO: Редактирование привычки*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(R.string.edit_icon_description)
                    )
                }

                IconButton(onClick = { /*TODO: Удаление привычки*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.delete_icon_description)
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarToday,
                        contentDescription = stringResource(R.string.calendar_icon_description)
                    )
                    Text(text = stringResource(habit.type.userReadableStringRes))
                }
            }
            item {
                UsefulHabitCircularDetailCard(score = habit.score?.toFloat() ?: 0f)
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    UsefulHabitDetailCard(
                        title = stringResource(R.string.useful_habit_details_streak),
                        value = "5",
                        modifier = Modifier.weight(1f)
                    )

                    UsefulHabitDetailCard(
                        title = stringResource(R.string.useful_habit_details_longest),
                        value = "62",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    UsefulHabitDetailCard(
                        title = stringResource(R.string.useful_habit_details_started),
                        value = "25 Мая",
                        modifier = Modifier.weight(1f)
                    )

                    UsefulHabitDetailCard(
                        title = stringResource(R.string.useful_habit_details_total),
                        value = "67",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UsefulHabitDetailsScreenPreview() {
    UsefulHabitDetailsScreen(
        habit = UsefulHabit(
            name = "Название",
            type = UsefulHabitFrequency.DAILY,
            score = 52,
            id = 5,
            completed = listOf<LocalDate>(),
            repeat = 1,
            streak = 3,
            completedByWeek = listOf<LocalDate>(),
        )
    )
}