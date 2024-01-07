package com.realikea.weatherforecast.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}