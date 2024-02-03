package com.realikea.weatherforecast.network.forecast

import com.squareup.moshi.Json

data class AstroDto(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    @field:Json(name = "moon_phase")
    val moonPhase: String
)