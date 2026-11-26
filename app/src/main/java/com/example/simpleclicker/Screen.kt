package com.example.simpleclicker

sealed interface Screen {
    data object Main : Screen
    data object  Shop : Screen
}