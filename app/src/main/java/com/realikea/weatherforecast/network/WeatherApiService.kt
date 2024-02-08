package com.realikea.weatherforecast.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/current.json?key=(secret)&days=1&aqi=yes&alerts=no&")
    suspend fun getWeatherData(
        @Query("q") latLong: String
    ): WeatherDto
}
