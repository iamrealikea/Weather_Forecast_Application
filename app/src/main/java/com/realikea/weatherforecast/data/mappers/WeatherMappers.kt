package com.realikea.weatherforecast.data.mappers

import android.annotation.SuppressLint
import com.realikea.weatherforecast.model.weather.LocationData
import com.realikea.weatherforecast.model.weather.WeatherData
import com.realikea.weatherforecast.model.weather.WeatherType
import com.realikea.weatherforecast.model.weather.WeatherInfo
import com.realikea.weatherforecast.network.LocationDataDto
import com.realikea.weatherforecast.network.WeatherDataDto
import com.realikea.weatherforecast.network.WeatherDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)
private data class IndexedLocationData(
    val index: Int,
    val data: LocationData
)

@SuppressLint("NewApi")
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val lastUpdated = lastUpdated
        val tempC = tempC
        val isDay = isDay
        val code = code
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = tempC,
                last_updated = lastUpdated,
                isDay = isDay,
                code = code,
                weatherType = WeatherType.fromWeatherWeb(code, isDay)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map { it.data }
    }
}

@SuppressLint("NewApi")
fun LocationDataDto.toLocationDataMap(): Map<Int, List<LocationData>> {
    return time.mapIndexed {index, time ->
        val locationName = locationName
        val regionName = regionName
        val countryName = countryName
        IndexedLocationData(
            index = index,
            data = LocationData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                name = locationName,
                region = regionName,
                country = countryName
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map {it.data}
    }
}

@SuppressLint("NewApi")
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val locationDataMap = locationData.toLocationDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        currentLocationData = locationDataMap
    )
}