package com.kawunus.habitu.diary.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DiaryScreen() {
    LazyColumn { }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun PreviewDiaryScreen() {
    Scaffold {
        DiaryScreen()
    }
}