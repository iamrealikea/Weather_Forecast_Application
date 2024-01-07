package com.realikea.weatherforecast.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast.json?key=c50b95a942614682bc341859230106&days=1&aqi=no&alerts=no&")
    suspend fun getWeatherData(
        @Query("q") latLong: String
    ): WeatherDto
}
