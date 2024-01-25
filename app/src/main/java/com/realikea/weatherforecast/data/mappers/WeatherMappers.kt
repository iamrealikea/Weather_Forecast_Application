package com.realikea.weatherforecast.data.mappers


import android.annotation.SuppressLint
import com.realikea.weatherforecast.model.weather.AirQualityData
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


/*
@SuppressLint("NewApi")
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<LocationData> > {
    return LocationData.mapIndexed {
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                temperatureCelsius = this.tempC,
                lastUpdated = this.lastUpdated,
                isDay = this.isDay,
                code = this.code,
                weatherType = WeatherType.fromWeatherWeb(this.code, this.isDay)
            )
        )
    }
}
*/

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

/*@SuppressLint("NewApi")
fun WeatherDataDto.toAirQualityDataMap(): AirQualityData{
    return AirQualityData(
        co = airQuality.co,
        no2 = airQuality.no2,
        o3 = airQuality.o3,
        so2 = airQuality.so2,
        pm2_5 = airQuality.pm2_5,
        pm10 = airQuality.pm10
    )
}*/
@SuppressLint("NewApi")
fun LocationDataDto.toLocationDataMap(): LocationData {
    return LocationData(
        name = locationName,
        region = regionName,
        country = countryName,
        localtime = localtime
    )
}

@SuppressLint("NewApi")
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val locationDataMap = locationData.toLocationDataMap()
    val currentWeatherData = weatherDataMap
    return WeatherInfo(
        //weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        currentLocationData = locationDataMap,
        //airQualityData = currentWeatherData.airQualityData
    )
}

