package com.kawunus.habityou.ui.screens.usefulhabits.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.habityou.R
import com.kawunus.habityou.domain.model.UsefulHabit
import com.kawunus.habityou.domain.model.UsefulHabitFrequency
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun UsefulHabitCard(
    usefulHabit: UsefulHabit,
    completedOnClick: (Int, LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    showStatistic: Boolean,
    todaysDate: LocalDate,
    expandedInitialValue: Boolean = false
) {
    var expanded by rememberSaveable { mutableStateOf(expandedInitialValue) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(300),
        label = "ArrowRotation"
    )

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(tween(300, easing = FastOutSlowInEasing))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = usefulHabit.name, style = MaterialTheme.typography.titleMedium
                    )
                    if (showStatistic) {
                        Text(
                            text = String.format(
                                stringResource(R.string.useful_habits_current_streak),
                                usefulHabit.streak
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                HabitToggleButton(
                    onCheckedChange = { completedOnClick(usefulHabit.id, todaysDate) },
                    checked = usefulHabit.completed.contains(todaysDate),
                    checkedSecondary = usefulHabit.completedByWeek.contains(todaysDate),
                    contentDescription = "${todaysDate.dayOfWeek} ${todaysDate.dayOfMonth}"
                )

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ExpandMore,
                        contentDescription = if (expanded) stringResource(R.string.collapse_icon_description)
                        else stringResource(
                            R.string.expand_icon_description
                        ),
                        modifier = Modifier.rotate(rotationAngle)
                    )
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    val firstDay = todaysDate
                    (6 downTo 1).forEach { offset ->
                        val date = firstDay.minusDays(offset.toLong())
                        UsefulHabitCardDay(
                            date = date,
                            completed = usefulHabit.completed.contains(date),
                            completedByWeek = usefulHabit.completedByWeek.contains(date),
                            onCheckedChange = {
                                completedOnClick(usefulHabit.id, date)
                            })
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.align(Alignment.End)) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = stringResource(R.string.edit_icon_description)
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = stringResource(R.string.delete_icon_description)
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.MoreHoriz,
                            contentDescription = stringResource(R.string.more_icon_description)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun UsefulHabitCardDay(
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    completed: Boolean,
    completedByWeek: Boolean,
    date: LocalDate
) {
    val weekday = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val dayOfMonth = date.dayOfMonth.toString()

    Column(
        modifier = modifier.width(45.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.height(50.dp),
            text = "$weekday\n$dayOfMonth",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        HabitToggleButton(
            onCheckedChange = onCheckedChange,
            checked = completed,
            checkedSecondary = completedByWeek,
            contentDescription = "${date.dayOfWeek} ${date.dayOfMonth}"
        )
    }
}

@Preview
@Composable
private fun UsefulHabitCardPreview() {
    UsefulHabitCard(
        usefulHabit = UsefulHabit(
            id = 1,
            name = "Reading",
            type = UsefulHabitFrequency.DAILY,
            streak = 2,
            score = 43,
            completed = listOf(),
            completedByWeek = listOf()
        ),
        completedOnClick = { _, _ -> },
        expandedInitialValue = false,
        showStatistic = true,
        todaysDate = LocalDate.parse("2025-01-09")
    )
}

@Preview
@Composable
private fun UsefulHabitCardExpandedPreview() {
    UsefulHabitCard(
        usefulHabit = UsefulHabit(
            id = 1,
            name = "Reading",
            type = UsefulHabitFrequency.DAILY,
            streak = 2,
            score = 43,
            completed = listOf(
                LocalDate.parse("2025-07-07"),
                LocalDate.parse("2025-07-05"),
                LocalDate.parse("2025-07-08")
            ),
            completedByWeek = listOf()
        ),
        completedOnClick = { _, _ -> },
        expandedInitialValue = true,
        showStatistic = true,
        todaysDate = LocalDate.parse("2025-05-26")
    )
}