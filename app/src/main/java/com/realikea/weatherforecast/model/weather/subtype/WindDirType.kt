package com.realikea.weatherforecast.model.weather.subtype

sealed class WindDirType(
    val windDirection: String
){
    object N : WindDirType(
        windDirection = "North"
    )
    object NNE : WindDirType(
        windDirection = "North-Northeast"
    )
    object NE : WindDirType(
        windDirection = "Northeast"
    )
    object ENE : WindDirType(
        windDirection = "East-Northeast"
    )
    object E : WindDirType(
        windDirection = "East"
    )
    object ESE : WindDirType(
        windDirection = "East-Southeast"
    )
    object SE : WindDirType(
        windDirection = "Southeast"
    )
    object SSE : WindDirType(
        windDirection = "South-Southwest"
    )
    object S : WindDirType(
        windDirection = "South"
    )
    object SSW : WindDirType(
        windDirection = "South-Southwest"
    )
    object SW : WindDirType(
        windDirection = "Southwest"
    )
    object WSW : WindDirType(
        windDirection = "West-Southwest"
    )
    object W : WindDirType(
        windDirection = "West"
    )
    object WNW : WindDirType(
        windDirection = "West-Northwest"
    )
    object NW : WindDirType(
        windDirection = "Northwest"
    )
    object NNW : WindDirType(
        windDirection = "North-Northwest"
    )
    object Unknown : WindDirType(
        windDirection = "Error"
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