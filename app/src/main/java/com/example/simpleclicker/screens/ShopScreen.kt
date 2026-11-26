package com.example.simpleclicker.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.simpleclicker.PropertiesViewModel

@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    propertiesViewModel: PropertiesViewModel
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
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 24.dp, end = 24.dp),
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
                        if (propertiesViewModel.clicks >= propertiesViewModel.tapCost) {
                            propertiesViewModel.onTapBuy()
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
                    Text("Cost: ${propertiesViewModel.tapCost}$")
                }
                // Second offer
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ElevatedButton(onClick = {
                        if (propertiesViewModel.clicks >= propertiesViewModel.passiveCost) {
                            propertiesViewModel.onPassiveBuy()
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
                    Text("Cost: ${propertiesViewModel.passiveCost}$")
                }
            }
        }
    }
}