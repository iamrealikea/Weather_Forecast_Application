package com.realikea.weatherforecast.network.forecast

data class ForecastDayDto(
    val date: List<String>,
    val astro: List<AstroDto>
)