package com.realikea.weatherforecast.model.weather.subtype

import androidx.annotation.StringRes
import com.realikea.weatherforecast.R

sealed class UsEpaIndex(
    @StringRes val indexDesc: Int
) {
    object Good: UsEpaIndex(
        indexDesc = R.string.good
    )
    object Moderate: UsEpaIndex(
        indexDesc = R.string.moderate
    )
    object UnhealthySensitive: UsEpaIndex(
        indexDesc = R.string.unhealthy_for_sensitive_group
    )
    object Unhealthy: UsEpaIndex(
        indexDesc = R.string.unhealthy
    )
    object VeryUnhealthy: UsEpaIndex(
        indexDesc = R.string.very_unhealthy
    )
    object Hazardous: UsEpaIndex(
        indexDesc = R.string.hazardous
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