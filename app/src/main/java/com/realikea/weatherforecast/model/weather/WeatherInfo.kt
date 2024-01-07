package com.realikea.weatherforecast.model.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
    val currentLocationData: Map<Int, List<LocationData>>?
)