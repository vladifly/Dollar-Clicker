package com.example.simpleclicker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpleclicker.PropertiesViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onShopClicked: () -> Unit,
    propertiesViewModel: PropertiesViewModel
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(top = 30.dp).weight(1f)
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
                        Text("$ per tap: ${propertiesViewModel.clicksPerTap}")
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
                        Text("$ per second: ${propertiesViewModel.clicksPerSec}")
                    }
                }
            }
            // Button
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedButton(onClick = { propertiesViewModel.onTap() }) {
                        Text("$$$")
                    }
                    Text("$${propertiesViewModel.clicks}")
                }
            }
            // Shop
            Box(
                modifier = Modifier.padding(bottom = 48.dp).weight(1f),
                contentAlignment = Alignment.BottomCenter,
            ) {
                ElevatedButton( onClick = onShopClicked ) {
                    Text("Shop")
                }
            }
        }
    }
}