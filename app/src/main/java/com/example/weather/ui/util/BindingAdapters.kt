package com.example.weather.ui.util

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.weather.R
import com.example.weather.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@BindingAdapter("weatherType")
fun ImageView.bindWeatherTypeImage(weatherType: WeatherType) {
    setImageResource(weatherType.iconRes)
    contentDescription = weatherType.weatherDesc
}

@BindingAdapter("time")
fun TextView.bindTimeText(time: LocalDateTime) {
    text = time.format(DateTimeFormatter.ofPattern("h:mm a"))
}

@BindingAdapter("day")
fun TextView.bindDayText(time: LocalDateTime) {
    text = when (time.dayOfMonth) {
        LocalDateTime.now().dayOfMonth -> "Today"
        LocalDateTime.now().plusDays(1).dayOfMonth -> "Tomorrow"
        else -> time.format(DateTimeFormatter.ofPattern("E"))
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("temperature")
fun TextView.bindTemperatureText(temp: Double) {
    text = "${temp.roundToInt()}°C"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("maxTemp", "minTemp")
fun TextView.bindTemperatureText(max: Double, min: Double) {
    text = "Max: ${max.roundToInt()}°C  Min: ${min.roundToInt()}°C"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("windSpeed")
fun TextView.bindWindSpeedText(temp: Double) {
    text = "${temp.roundToInt()} km/h"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("humidity")
fun TextView.bindHumidityText(temp: Double) {
    text = "${temp.roundToInt()} %"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("pressure")
fun TextView.bindPressureText(temp: Double) {
    text = "${temp.roundToInt()}"
}

