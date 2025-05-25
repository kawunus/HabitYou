package com.kawunus.habityou.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun formatDate(timestamp: Long): String {
    val sdf = remember { SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) }
    return sdf.format(Date(timestamp))
}