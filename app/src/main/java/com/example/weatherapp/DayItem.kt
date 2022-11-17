package com.example.weatherapp

data class DayItem(
    val city: String,
    val data: String,
    val condition: String,
    val imageUrl: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String,
    val realFeelTemp: String,
    val humidity: String,
    val pressure: String,
    val wind: String,
    val currentTemp: String
)
