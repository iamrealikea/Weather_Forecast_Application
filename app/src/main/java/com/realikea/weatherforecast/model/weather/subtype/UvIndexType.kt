package com.realikea.weatherforecast.model.weather.subtype

import androidx.annotation.DrawableRes
import com.realikea.weatherforecast.R

sealed class UvIndexType(
    val uvIndexDesc: String,
    val recommendDesc: String,
    @DrawableRes val colorIndex: Int
) {
    object Low : UvIndexType(
        uvIndexDesc = "Low",
        recommendDesc = "You can safely enjoy being outside! " +
                "Wear sunglasses on bright days.",
        colorIndex = R.drawable.low_uv
    )
    object Moderate : UvIndexType(
        uvIndexDesc = "Moderate",
        recommendDesc = "Stay in shade near midday when the sun is strongest. " +
                "If outdoors, wear sun-protective clothing, a wide-brimmed hat, and UV-blocking sunglasses.",
        colorIndex = R.drawable.moderate_uv
    )
    object High : UvIndexType(
        uvIndexDesc = "High",
        recommendDesc = "Reduce time in the sun between 10 a.m. and 4 p.m. " +
                "If outdoors, seek shade and wear sun-protective clothing, a wide-brimmed hat, and UV-blocking sunglasses.",
        colorIndex = R.drawable.high_uv
    )
    object VeryHigh : UvIndexType(
        uvIndexDesc = "Very High",
        recommendDesc = "Minimize sun exposure between 10 a.m. and 4 p.m. " +
                "If outdoors, seek shade and wear sun-protective clothing, a wide-brimmed hat, and UV-blocking sunglasses.",
        colorIndex = R.drawable.very_high_uv
    )
    object Extreme : UvIndexType(
        uvIndexDesc = "Extreme",
        recommendDesc = "Try to avoid sun exposure between 10 a.m. and 4 p.m. " +
                "If outdoors, seek shade and wear sun-protective clothing, a wide-brimmed hat, and UV-blocking sunglasses.",
        colorIndex = R.drawable.very_high_uv
    )
    object Unknow : UvIndexType(
        uvIndexDesc = "Null",
        recommendDesc = "Null",
        colorIndex = R.drawable.low_uv
    )

    companion object {
        fun fromWeatherWeb(uv: Double): UvIndexType {
            return when (uv) {
                0.0 -> Low
                1.0 -> Low
                2.0 -> Low
                3.0 -> Moderate
                4.0 -> Moderate
                5.0 -> Moderate
                6.0 -> High
                7.0 -> High
                8.0 -> VeryHigh
                9.0 -> VeryHigh
                10.0 -> VeryHigh
                11.0 -> Extreme
                else -> Unknow
            }
        }
    }
}