package com.kawunus.habityou.ui.common.hint

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.habityou.R
import com.kawunus.habityou.ui.theme.Typography

/**
 * Displays a fullscreen hint with a centered icon and text.
 *
 * This composable is useful for showing placeholder or informational messages,
 * such as "No data available", typically in empty states.
 *
 * @param modifier Modifier to be applied to the root container.
 * @param icon The [ImageVector] icon to be displayed.
 * @param iconContentDescription String resource ID for the content description of the icon, used for accessibility.
 * @param text String resource ID for the message text displayed below the icon.
 */
@Composable
fun FullscreenHint(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    @StringRes iconContentDescription: Int,
    @StringRes text: Int
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = icon,
                contentDescription = stringResource(iconContentDescription)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(text),
                style = Typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FullscreenHintPreview() {
    FullscreenHint(
        modifier = Modifier.fillMaxSize(),
        icon = Icons.Filled.Add,
        iconContentDescription = R.string.add_icon_description,
        text = R.string.useful_habits_empty
    )
}