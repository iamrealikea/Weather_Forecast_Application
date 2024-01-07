package com.realikea.weatherforecast.model.weather

import java.time.LocalDateTime

data class LocationData(
    val time: LocalDateTime,
    val name: String,
    val region: String,
    val country: String
)