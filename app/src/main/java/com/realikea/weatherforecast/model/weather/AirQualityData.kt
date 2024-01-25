package com.realikea.weatherforecast.model.weather

import androidx.compose.ui.unit.Dp
import com.realikea.weatherforecast.model.weather.subtype.UvIndexType

data class AirQualityData(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2_5: Double,
    val pm10: Double,
)