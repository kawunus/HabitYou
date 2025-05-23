package com.kawunus.habitu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kawunus.habitu.ui.root.RootScreen
import com.kawunus.habitu.ui.theme.HabituTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabituTheme {
                RootScreen()
            }
        }
    }
}