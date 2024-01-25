package com.realikea.weatherforecast.model.weather.subtype

import com.squareup.moshi.Json

data class AirQualityDto(
    @field:Json(name = "co")
    val co: Double,
    @field:Json(name = "no2")
    val no2: Double,
    @field:Json(name = "o3")
    val o3: Double,
    @field:Json(name = "so2")
    val so2: Double,
    @field:Json(name = "pm2_5")
    val pm2_5: Double,
    @field:Json(name = "pm10")
    val pm10: Double,
    @field:Json(name = "us-epa-index")
    val usEpaIndex: Int
)