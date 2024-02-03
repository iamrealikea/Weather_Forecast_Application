package com.realikea.weatherforecast.model.weather.subtype

import androidx.annotation.StringRes
import com.realikea.weatherforecast.R

sealed class WindDirType(
    @StringRes val windDirection: Int
){
    object N : WindDirType(
        windDirection = R.string.north
    )
    object NNE : WindDirType(
        windDirection = R.string.north_northeast
    )
    object NE : WindDirType(
        windDirection = R.string.northeast
    )
    object ENE : WindDirType(
        windDirection = R.string.east_northeast
    )
    object E : WindDirType(
        windDirection = R.string.east
    )
    object ESE : WindDirType(
        windDirection = R.string.east_southeast
    )
    object SE : WindDirType(
        windDirection = R.string.southeast
    )
    object SSE : WindDirType(
        windDirection = R.string.south_southeast
    )
    object S : WindDirType(
        windDirection = R.string.south
    )
    object SSW : WindDirType(
        windDirection = R.string.south_southwest
    )
    object SW : WindDirType(
        windDirection = R.string.southwest
    )
    object WSW : WindDirType(
        windDirection = R.string.west_southwest
    )
    object W : WindDirType(
        windDirection = R.string.west
    )
    object WNW : WindDirType(
        windDirection = R.string.west_northwest
    )
    object NW : WindDirType(
        windDirection = R.string.northwest
    )
    object NNW : WindDirType(
        windDirection = R.string.north_northwest
    )
    object Unknown : WindDirType(
        windDirection = R.string.error
    )

    companion object{
        fun fromWeatherWeb(windDir: String): WindDirType{
            return when (windDir){
                "N" -> N
                "NNE" -> NNE
                "NE" -> NE
                "ENE" -> ENE
                "E" -> E
                "ESE" -> ESE
                "SE" -> SE
                "SSE" -> SSE
                "S" -> S
                "SSW" -> SSW
                "SW" -> SW
                "WSW" -> WSW
                "W" -> W
                "WNW" -> WNW
                "NW" -> NW
                "NNW" -> NNW
                else -> Unknown
            }
        }
    }
}