package com.realikea.weatherforecast.model.weather.subtype

sealed class UsEpaIndex(
    val indexDesc: String
) {
    object Good: UsEpaIndex(
        indexDesc = "Good"
    )
    object Moderate: UsEpaIndex(
        indexDesc = "Moderate"
    )
    object UnhealthySensitive: UsEpaIndex(
        indexDesc = "Unhealthy for sensitive group"
    )
    object Unhealthy: UsEpaIndex(
        indexDesc = "Unhealthy"
    )
    object VeryUnhealthy: UsEpaIndex(
        indexDesc = "Very Unhealthy"
    )
    object Hazardous: UsEpaIndex(
        indexDesc = "Hazardous"
    )

    companion object {
        fun fromWeatherWeb(usEpaIndex: Int): UsEpaIndex {
            return when (usEpaIndex){
                1 -> Good
                2 -> Moderate
                3 -> UnhealthySensitive
                4 -> Unhealthy
                5 -> VeryUnhealthy
                6 -> Hazardous
                else -> Moderate
            }
        }
    }
}