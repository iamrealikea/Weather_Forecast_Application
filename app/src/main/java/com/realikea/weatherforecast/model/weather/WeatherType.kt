package com.realikea.weatherforecast.model.weather

import androidx.annotation.DrawableRes
import com.realikea.weatherforecast.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val imageRes: Int
){
    //1000
    object SunnyDay : WeatherType(
        weatherDesc = "Sunny",
        imageRes = R.drawable.sunny
    )
    object ClearNight : WeatherType(
        weatherDesc = "Clear",
        imageRes = R.drawable.clear
    )
    //1003
    object PartlyCloudyDay : WeatherType(
        weatherDesc = "Partly cloudy",
        imageRes = R.drawable.partly_cloudy
    )
    object PartlyCloudyNight : WeatherType(
        weatherDesc = "Partly cloudy",
        imageRes = R.drawable.partly_cloudy_night
    )
    //1006
    object CloudyDay : WeatherType(
        weatherDesc = "Cloudy",
        imageRes = R.drawable.overcast
    )
    object CloudyNight : WeatherType(
        weatherDesc = "Cloudy",
        imageRes = R.drawable.overcast
    )
    //1009
    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        imageRes = R.drawable.overcast
    )
    //1030
    object Mist : WeatherType(
        weatherDesc = "Mist",
        imageRes = R.drawable.fog
    )
    //1063
    object PatchyRainDay : WeatherType(
        weatherDesc = "Patchy rain possible",
        imageRes = R.drawable.patchy_light_rain
    )
    object PatchyRainNight : WeatherType(
        weatherDesc = "Patchy rain possible",
        imageRes = R.drawable.patchy_light_rain_night
    )
    //1066
    object PatchySnowDay : WeatherType(
        weatherDesc = "Patchy snow possible",
        imageRes = R.drawable.light_snow_shower
    )
    object PatchySnowNight : WeatherType(
        weatherDesc = "Patchy snow possible",
        imageRes = TODO()
    )




    companion object{
        fun fromWeatherWeb(code: Int, is_day: Int): WeatherType{
            return when (code) {
                1000 -> SunnyDay
                1003 -> PartlyCloudyDay
                1006 -> CloudyDay
                1009 -> Overcast
                1030 -> Mist
                1063 -> PatchyRainDay
                1066 -> PatchySnowDay

                else -> Overcast
                }
            }

    }
}