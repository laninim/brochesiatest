package com.laninim.brochesiatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.laninim.brochesiatest.ui.theme.BrochesiatestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrochesiatestTheme {

            }
        }
    }
}

