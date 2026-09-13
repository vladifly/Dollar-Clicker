package com.example.simpleclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object GlobalProperties {
    var clicks by mutableStateOf(0)
    var clicksPerSec by mutableStateOf(0)
    var clicksPerTap by mutableStateOf(1)
}