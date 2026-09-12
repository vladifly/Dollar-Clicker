package com.example.simpleclicker.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleclicker.CurrentScreen
import com.example.simpleclicker.GlobalProperties
import com.example.simpleclicker.ui.theme.SimpleClickerTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

private val global = GlobalProperties

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            // Total clicks
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("$ per tap: ${global.clicksPerTap}")
                }
            }
            // Clicks per second
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("$ per second: ${global.clicksPerSec}")
                }
            }
        }
        // Button
        Box(contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier.padding(24.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ElevatedButton(onClick = { global.clicks += global.clicksPerTap }) {
                            Text("$$$")
                        }
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("$${global.clicks}")
                    }
                }
            }
        }
        // Shop
        Box(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 65.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                ElevatedButton( onClick = { global.curScreen = CurrentScreen.Shop() } ) {
                    Text("Shop")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SimpleClickerTheme() {
        MainScreen()
    }
}