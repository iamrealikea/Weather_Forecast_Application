package com.realikea.weatherforecast.model.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val last_updated: String,
    val isDay: Int,
    val code: Int,
    val weatherType: WeatherType
)