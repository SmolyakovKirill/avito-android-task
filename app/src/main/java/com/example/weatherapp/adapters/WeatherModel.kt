package com.example.weatherapp.adapters

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imageUrl: String,
    val hours: String,
    val realFeelTemp: String,
    val humidity: String,
    val pressure: String,
    val wind: String,
)
