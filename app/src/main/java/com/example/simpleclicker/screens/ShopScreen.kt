package com.example.simpleclicker.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleclicker.CurrentScreen
import com.example.simpleclicker.GlobalProperties
import com.example.simpleclicker.ui.theme.SimpleClickerTheme

private val global = GlobalProperties
private var Plus1PerTapCost by mutableStateOf(75)
private var Plus1PerSecondCost by mutableStateOf(250)

@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.padding(top = 48.dp)
        ) {
            Row {
                Surface(
                    modifier = Modifier.weight(1f).padding(start = 24.dp, end = 24.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    ElevatedButton(onClick = onBackClicked) {
                        Text("Back to menu")
                    }
                }
            }
            Row(modifier = Modifier.padding(top = 30.dp)) {
                val context = LocalContext.current

                // First offer
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ElevatedButton(onClick = {
                        if (global.clicks >= Plus1PerTapCost) {
                            global.clicks -= Plus1PerTapCost
                            global.clicksPerTap++
                            Plus1PerTapCost += Plus1PerTapCost / 2
                            Toast.makeText(context, "Successfully!", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(context, "Not enough $!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }) {
                        Text("Buy")
                    }
                    Text("+1 $ per tap")
                    Text("Cost: $Plus1PerTapCost$")
                }
                // Second offer
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ElevatedButton(onClick = {
                        if (global.clicks >= Plus1PerSecondCost) {
                            global.clicks -= Plus1PerSecondCost
                            global.clicksPerSec++
                            Plus1PerSecondCost += Plus1PerSecondCost / 2
                            Toast.makeText(context, "Successfully!", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(context, "Not enough $!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }) {
                        Text("Buy")
                    }
                    Text("+1 $ per second")
                    Text("Cost: $Plus1PerSecondCost$")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopScenePreview() {
    SimpleClickerTheme() {
        ShopScreen(onBackClicked = {})
    }
}