package com.realikea.weatherforecast.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.realikea.weatherforecast.R

data class HourlyData (
    val timeForecast: String,
    @DrawableRes val imageResourceId: Int,
    @StringRes val tempAtTime: Int,
    @StringRes val humidityAtTime: Int
)

