package com.realikea.weatherforecast.network

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "last_updated")
    val lastUpdated: String,
    @field:Json(name = "temp_c")
    val tempC: Double,
    @field:Json(name = "is_day")
    val isDay: Int,
    @field:Json(name = "code")
    val code: Int,


    )