package com.example.weather.domain.model

import java.time.LocalDateTime

data class WeatherDay(
    val time: LocalDateTime,
    val maxTemperature: Double,
    val minTemperature: Double,
    val description: String,
    val weatherType: WeatherType
)
