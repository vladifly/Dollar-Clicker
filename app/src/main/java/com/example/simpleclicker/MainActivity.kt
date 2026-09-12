package com.example.simpleclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpleclicker.screens.MainScreen
import com.example.simpleclicker.screens.ShopScreen
import com.example.simpleclicker.ui.theme.SimpleClickerTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

val global = GlobalProperties

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleClickerTheme {
                LaunchedEffect(Unit) {
                    while (true) {
                        delay(1.seconds)
                        global.clicks += global.clicksPerSec
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when(global.curScreen) {
                        is CurrentScreen.Main ->
                            MainScreen(modifier = Modifier.padding(innerPadding))
                        is CurrentScreen.Shop ->
                            ShopScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}