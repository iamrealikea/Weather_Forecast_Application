package com.realikea.weatherforecast.model.weather

import com.realikea.weatherforecast.network.forecast.AstroDto
import java.time.LocalDateTime

data class ForecastData(
    val date: LocalDateTime,
    val astroDto: AstroDto
)