package com.example.tuneguessr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tuneguessr.ui.theme.TuneGuessrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuneGuessrTheme {
                TuneGuessrApp()
            }
        }
    }
}
