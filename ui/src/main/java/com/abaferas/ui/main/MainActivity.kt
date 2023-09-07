package com.abaferas.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.abaferas.ui.theme.IKnowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val x = "Hassan"
        Log.w("X010", x.split(",").toString())
        setContent {
            IKnowTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    IKnowApp()
                }
            }
        }
    }
}