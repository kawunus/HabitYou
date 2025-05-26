package com.kawunus.habityou.ui.screens.usefulhabitinfo.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.habityou.R
import com.kawunus.habityou.ui.theme.Typography

@Composable
fun UsefulHabitCircularDetailCard(
    modifier: Modifier = Modifier,
    score: Float,
) {
    var initialScore by rememberSaveable {
        mutableFloatStateOf(0f)
    }

    val animatedScore by animateFloatAsState(
        targetValue = initialScore,
        animationSpec = tween(durationMillis = 1000),
        label = "animatedScore"
    )

    LaunchedEffect(score) {
        initialScore = score
    }

    OutlinedCard(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            val foregroundColor = MaterialTheme.colorScheme.primary
            val inactiveColor = MaterialTheme.colorScheme.primaryContainer
            val lineThickness = 16.dp
            val lineThicknessInactive = 8.dp

            Canvas(modifier = Modifier.fillMaxSize()) {
                val angle = animatedScore * 360 / 100
                val diameter = size.minDimension
                val arcSize = Size(diameter, diameter)
                val arcOffset = Offset(
                    center.x - diameter / 2,
                    center.y - diameter / 2
                )

                drawArc(
                    color = inactiveColor,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = lineThicknessInactive.toPx(), cap = StrokeCap.Round),
                    size = arcSize,
                    topLeft = arcOffset
                )

                drawArc(
                    color = foregroundColor,
                    startAngle = -90f,
                    sweepAngle = angle,
                    useCenter = false,
                    style = Stroke(width = lineThickness.toPx(), cap = StrokeCap.Round),
                    size = arcSize,
                    topLeft = arcOffset
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.useful_habit_details_score),
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${animatedScore.toInt()}%",
                    style = Typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewUsefulHabitCircularDetailCard() {
    UsefulHabitCircularDetailCard(
        score = 52f
    )
}
