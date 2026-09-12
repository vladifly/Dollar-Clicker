package com.example.simpleclicker

sealed class CurrentScreen {
    class Main : CurrentScreen()
    class Shop : CurrentScreen()
}