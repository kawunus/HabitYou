package com.kawunus.habityou.ui.screens.usefulhabits.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kawunus.habityou.domain.model.UsefulHabit
import java.time.LocalDate

@Composable
internal fun UsefulHabitsContent(
    usefulHabits: List<UsefulHabit>,
    modifier: Modifier = Modifier,
    showStreaks: Boolean,
    showScore: Boolean,
    todaysDate: LocalDate,
    onDeleteClick: (UsefulHabit) -> Unit,
    onEditClick: (UsefulHabit) -> Unit,
    onMoreClick: (UsefulHabit) -> Unit,
    completedOnClick: (Int, LocalDate) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(usefulHabits) { habit ->
            UsefulHabitCard(
                usefulHabit = habit,
                completedOnClick = { id, date ->
                    completedOnClick.invoke(id, date)
                },
                showStatistic = showStreaks || showScore,
                todaysDate = todaysDate,
                onDeleteIconClick = {
                    onDeleteClick.invoke(habit)
                },
                onEditIconClick = { habit ->
                    onEditClick.invoke(habit)
                },
                onMoreIconClick = { habit ->
                    onMoreClick.invoke(habit)
                }
            )
        }
    }
}