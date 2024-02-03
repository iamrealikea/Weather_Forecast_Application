package com.realikea.weatherforecast.data.mappers


import android.annotation.SuppressLint
import android.icu.util.LocaleData
import com.realikea.weatherforecast.model.weather.AirQualityData
import com.realikea.weatherforecast.model.weather.ForecastData
import com.realikea.weatherforecast.model.weather.LocationData
import com.realikea.weatherforecast.model.weather.WeatherData
import com.realikea.weatherforecast.model.weather.WeatherInfo
import com.realikea.weatherforecast.model.weather.WeatherType
import com.realikea.weatherforecast.model.weather.subtype.UsEpaIndex
import com.realikea.weatherforecast.network.AirQuality
import com.realikea.weatherforecast.model.weather.subtype.UvIndexType
import com.realikea.weatherforecast.model.weather.subtype.WindDirType
import com.realikea.weatherforecast.network.LocationDataDto
import com.realikea.weatherforecast.network.WeatherDataDto
import com.realikea.weatherforecast.network.WeatherDto
import com.realikea.weatherforecast.network.forecast.ForecastDataDto
import com.realikea.weatherforecast.network.forecast.ForecastDayDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.zip.DataFormatException


data class IndexedForecastData(
    val index: Int,
    val data: ForecastData
)

@SuppressLint("NewApi")
fun WeatherDataDto.toWeatherDataMap(): WeatherData {
    return (
        WeatherData(
            temperatureCelsius = tempC,
            lastUpdated = lastUpdated,
            code = condition.code,
            isDay = isDay,
            uv = uv,
            weatherType = WeatherType.fromWeatherWeb(this.condition.code,this.isDay),
            feelslikeCelsius = feelslikeCelsius,
            humidity = humidity,
            usEpaIndex = airQuality.usEpaIndex,
            uvIndex = UvIndexType.fromWeatherWeb(this.uv),
            usEpaIndexType = UsEpaIndex.fromWeatherWeb(this.airQuality.usEpaIndex),
            airQualityData = AirQualityData(airQuality.co,airQuality.no2,airQuality.o3,airQuality.pm10,airQuality.pm2_5,airQuality.so2),
            windKph = windKph,
            windDirType = WindDirType.fromWeatherWeb(windDir),
            visKM = visKM
    )
    )
}

@SuppressLint("NewApi")
fun LocationDataDto.toLocationDataMap(): LocationData {
    return LocationData(
        name = locationName,
        region = regionName,
        country = countryName,
        localtime = localtime
    )
}

/*@SuppressLint("NewApi")
fun ForecastDataDto.toForecastDataMap(): List<ForecastData> {
    return ForecastData(
        date = this.forecastDay.date,
        astroDto = this.forecastDay.astro
    )
}*/

@SuppressLint("NewApi")
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val locationDataMap = locationData.toLocationDataMap()
    val currentWeatherData = weatherDataMap
    //val forecastDataMap = forecastData.toForecastDataMap()
    return WeatherInfo(
        //weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        currentLocationData = locationDataMap,
        //airQualityData = currentWeatherData.airQualityData
    )
}

