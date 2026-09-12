package com.example.simpleclicker.screens

import android.widget.Toast
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
fun ShopScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column {
            Surface(
                modifier = Modifier.padding(top = 30.dp),
                color = MaterialTheme.colorScheme.primary
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row {
                        Surface(
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            ElevatedButton(onClick = { global.curScreen = CurrentScreen.Main() }) {
                                Text("Back to menu")
                            }
                        }
                    }
                }
            }
            Row(modifier = Modifier.padding(top = 30.dp)) {
                val context = LocalContext.current

                // First offer
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .width(30.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
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
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("+1 $ per tap")
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Cost: $Plus1PerTapCost$")
                        }
                    }
                }
                // Second offer
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .width(30.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
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
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("+1 $ per second")
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Cost: $Plus1PerSecondCost$")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopScenePreview() {
    SimpleClickerTheme() {
        ShopScreen()
    }
}