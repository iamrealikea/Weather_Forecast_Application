package com.realikea.weatherforecast.network

import com.squareup.moshi.Json

data class AirQuality(
    @field:Json(name = "co")
    val co: Double,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm2_5: Double,
    val so2: Double,
    //val usepaindex: Int
)