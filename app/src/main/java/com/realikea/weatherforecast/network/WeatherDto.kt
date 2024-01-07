package com.realikea.weatherforecast.network

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "location")
    val locationData: LocationDataDto,
    @field:Json(name = "current")
    val weatherData: WeatherDataDto

)