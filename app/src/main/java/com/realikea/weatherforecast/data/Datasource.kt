package com.realikea.weatherforecast.data

import com.realikea.weatherforecast.R
import com.realikea.weatherforecast.model.HourlyData

object DataSource {
    val hourlyData = listOf(
        HourlyData("12:00", R.drawable.sunny, R.string.temp_1200, R.string.humidity_1200),
        HourlyData("13:00", R.drawable.sunny, R.string.temp_1300, R.string.humidity_1300)
    )
}