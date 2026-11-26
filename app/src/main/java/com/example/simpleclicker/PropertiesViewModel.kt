package com.example.simpleclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class PropertiesViewModel : ViewModel() {
    var clicks by mutableStateOf(0)
        private set
    var clicksPerSec by mutableStateOf(0)
        private set
    var clicksPerTap by mutableStateOf(1)
        private set
    var tapCost by mutableStateOf(75)
        private set
    var passiveCost by mutableStateOf(250)
        private set
    var currentScreen by mutableStateOf<Screen>(Screen.Main)
        private set


    fun onTap() {
        clicks += clicksPerTap
    }
    fun onTapBuy(): Boolean {
        if (clicks < tapCost) return false
        clicks -= tapCost
        clicksPerTap++
        tapCost += tapCost / 2
        return true
    }
    fun onPassiveBuy(): Boolean {
        if (clicks < tapCost) return false
        clicks -= passiveCost
        clicksPerSec++
        passiveCost += passiveCost / 2
        return true
    }
    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }

    private val tickerFlow = flow {
        while (true) {
            delay(1.seconds)
            emit(Unit)
        }
    }

    init {
        viewModelScope.launch {
            tickerFlow
                .filter { clicksPerSec > 0 }
                .collect {
                    clicks += clicksPerSec
                }
        }
    }
}