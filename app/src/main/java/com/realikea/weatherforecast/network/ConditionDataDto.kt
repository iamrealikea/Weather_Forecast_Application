package com.realikea.weatherforecast.network

import com.squareup.moshi.Json

data class ConditionDataDto(
    @field:Json(name = "code")
    val code: Int
)