package com.example.simpleclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.simpleclicker.screens.MainScreen
import com.example.simpleclicker.screens.ShopScreen
import com.example.simpleclicker.ui.theme.SimpleClickerTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val propertiesViewModel: PropertiesViewModel = viewModel()
            SimpleClickerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when(propertiesViewModel.currentScreen) {
                        is Screen.Main ->
                            MainScreen(
                                modifier = Modifier.padding(innerPadding),
                                onShopClicked = { propertiesViewModel.navigateTo(Screen.Shop) },
                                propertiesViewModel = propertiesViewModel
                            )
                        is Screen.Shop ->
                            ShopScreen(
                                modifier = Modifier.padding(innerPadding),
                                onBackClicked = { propertiesViewModel.navigateTo(Screen.Main) },
                                propertiesViewModel = propertiesViewModel
                            )
                    }
                }
            }
        }
    }
}