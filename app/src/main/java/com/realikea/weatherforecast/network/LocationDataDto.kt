package com.realikea.weatherforecast.network

import com.squareup.moshi.Json

class LocationDataDto(
    val time: List<String>,
    @field:Json(name = "name")
    val locationName: String,
    @field:Json(name = "region")
    val regionName: String,
    @field:Json(name = "country")
    val countryName: String
)