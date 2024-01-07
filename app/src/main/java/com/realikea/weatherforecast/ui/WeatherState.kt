package com.realikea.weatherforecast.ui

import com.realikea.weatherforecast.model.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)