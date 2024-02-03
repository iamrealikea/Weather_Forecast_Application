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
        imageRes = R.drawable.patchy_snow_night
    )
    //1069
    object PatchySleetDay : WeatherType(
        weatherDesc = "Patchy sleet possible",
        imageRes = R.drawable.light_sleet
    )
    object PatchySleetNight : WeatherType(
        weatherDesc = "Patchy sleet possible",
        imageRes = R.drawable.light_sleet_night
    )
    //1072
    object PatchyFreezingDay : WeatherType(
        weatherDesc = "Patchy freezing drizzle possible",
        imageRes = R.drawable.freezing_dizzle
    )
    object PatchyFreezingNight : WeatherType(
        weatherDesc = "Patchy freezing drizzle possible",
        imageRes = R.drawable.freezing_dizzle
    )
    //1087
    object ThunderyOutbreaksDay : WeatherType(
        weatherDesc = "Thundery outbreaks possible",
        imageRes = R.drawable.thunder_outbreak
    )
    object ThunderyOutbreaksNight : WeatherType(
        weatherDesc = "Thundery outbreaks possible",
        imageRes = R.drawable.rain_tstorm
    )
    //1114
    object BlowingSnowDay : WeatherType(
        weatherDesc = "Blowing Snow",
        imageRes = R.drawable.blowing_snow
    )
    object BlowingSnowNight : WeatherType(
        weatherDesc = "Blowing Snow",
        imageRes = R.drawable.blowing_snow
    )
    //1117
    object BlizzardDay : WeatherType(
        weatherDesc = "Blizzard",
        imageRes = R.drawable.blizzard
    )
    object BlizzardNight : WeatherType(
        weatherDesc = "Blizzard",
        imageRes = R.drawable.blizzard
    )
    //1135
    object FogDay : WeatherType(
        weatherDesc = "Fog",
        imageRes = R.drawable.fog
    )
    object FogNight : WeatherType(
        weatherDesc = "Fog",
        imageRes = R.drawable.fog
    )
    //1147
    object FreezingFogDay : WeatherType(
        weatherDesc = "Freezing fog",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    object FreezingFogNight : WeatherType(
        weatherDesc = "Freezing fog",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    //1150
    object PatchyDrizzleDay : WeatherType(
        weatherDesc = "Patchy light drizzle",
        imageRes = R.drawable.heavy_rain
    )
    object PatchyDrizzleNight : WeatherType(
        weatherDesc = "Patchy light drizzle",
        imageRes = R.drawable.heavy_rain
    )
    //1153
    object LightDrizzleDay : WeatherType(
        weatherDesc = "Light drizzle",
        imageRes = R.drawable.light_rain
    )
    object LightDrizzleNight : WeatherType(
        weatherDesc = "Light drizzle",
        imageRes = R.drawable.light_rain
    )
    //1168
    object FreezingDrizzleDay : WeatherType(
        weatherDesc = "Freezing drizzle",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    object FreezingDrizzleNight : WeatherType(
        weatherDesc = "Freezing drizzle",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    //1171
    object HeavyFreezingDrizzleDay : WeatherType(
        weatherDesc = "Heavy Freezing Drizzle",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    object HeavyFreezingDrizzleNight : WeatherType(
        weatherDesc = "Heavy Freezing Drizzle",
        imageRes = R.drawable.frezzing_fog_dizzle
    )
    //1180
    object PatchyLightRainDay : WeatherType(
        weatherDesc = "Patchy light rain",
        imageRes = R.drawable.patchy_light_rain
    )
    object PatchyLightRainNight : WeatherType(
        weatherDesc = "Patchy light rain",
        imageRes = R.drawable.patchy_light_rain_night
    )
    //1183
    object LightRainDay : WeatherType(
        weatherDesc = "Light rain",
        imageRes = R.drawable.light_rain
    )
    object LightRainNight : WeatherType(
        weatherDesc = "Light rain",
        imageRes = R.drawable.light_rain
    )
    //1186
    object ModerateRainATDay : WeatherType(
        weatherDesc = "Moderate rain at times",
        imageRes = R.drawable.patchy_light_rain
    )
    object ModerateRainATNight : WeatherType(
        weatherDesc = "Moderate rain at times",
        imageRes = R.drawable.patchy_light_rain_night
    )
    //1189
    object ModerateRainDay : WeatherType(
        weatherDesc = "Moderate rain",
        imageRes = R.drawable.light_rain
    )
    object ModerateRainNight : WeatherType(
        weatherDesc = "Moderate rain",
        imageRes = R.drawable.light_rain
    )
    //1192
    object HeavyRainATDay : WeatherType(
        weatherDesc = "Heavy rain at times",
        imageRes = R.drawable.heavy_rain_shower
    )
    object HeavyRainATNight : WeatherType(
        weatherDesc = "Heavy rain at times",
        imageRes = R.drawable.heavy_rain_night
    )
    //1195
    object HeavyRainDay : WeatherType(
        weatherDesc = "Heavy rain",
        imageRes = R.drawable.heavy_rain
    )
    object HeavyRainNight : WeatherType(
        weatherDesc = "Heavy rain",
        imageRes = R.drawable.heavy_rain
    )
    //1198
    object LightFreezingRainDay : WeatherType(
        weatherDesc = "Light freezing rain",
        imageRes = R.drawable.freezing_rain
    )
    object LightFreezingRainNight : WeatherType(
        weatherDesc = "Light freezing rain",
        imageRes = R.drawable.freezing_rain
    )
    //1201
    object ModerateFreezingRainDay : WeatherType(
        weatherDesc = "Moderate or heavy freezing rain",
        imageRes = R.drawable.freezing_rain
    )
    object ModerateFreezingRainNight : WeatherType(
        weatherDesc = "Moderate or heavy freezing rain",
        imageRes = R.drawable.freezing_rain
    )
    //1204
    object LightSleetDay : WeatherType(
        weatherDesc = "Light sleet",
        imageRes = R.drawable.light_sleet
    )
    object LightSleetNight : WeatherType(
        weatherDesc = "Light sleet",
        imageRes = R.drawable.light_sleet_night
    )
    //1207
    object ModerateSleetDay : WeatherType(
        weatherDesc = "Moderate or heavy sleet",
        imageRes = R.drawable.moderate_sleet
    )
    object ModerateSleetNight : WeatherType(
        weatherDesc = "Moderate or heavy sleet",
        imageRes = R.drawable.moderate_sleet
    )
    //1210
    object PatchyLightSnowDay : WeatherType(
        weatherDesc = "Patchy light snow",
        imageRes = R.drawable.light_snow_shower
    )
    object PatchyLightSnowNight : WeatherType(
        weatherDesc = "Patchy light snow",
        imageRes = R.drawable.patchy_snow_night
    )
    //1213
    object LightSnowDay : WeatherType(
        weatherDesc = "Light snow",
        imageRes = R.drawable.light_snow
    )
    object LightSnowNight : WeatherType(
        weatherDesc = "Light snow",
        imageRes = R.drawable.light_snow
    )
    //1216
    object PatchyModerateSnowDay : WeatherType(
        weatherDesc = "Patchy moderate snow",
        imageRes = R.drawable.light_snow_shower
    )
    object PatchyModerateSnowNight : WeatherType(
        weatherDesc = "Patchy moderate snow",
        imageRes = R.drawable.patchy_snow_night
    )
    //1219
    object ModerateSnowDay : WeatherType(
        weatherDesc = "Moderate snow",
        imageRes = R.drawable.light_snow
    )
    object ModerateSnowNight : WeatherType(
        weatherDesc = "Moderate snow",
        imageRes = R.drawable.light_snow
    )
    //1222
    object PatchyHeavySnowDay : WeatherType(
        weatherDesc = "Patchy heavy snow",
        imageRes = R.drawable.heavy_snow_shower
    )
    object PatchyHeavySnowNight : WeatherType(
        weatherDesc = "Patchy heavy snow",
        imageRes = R.drawable.heavy_snow_night
    )
    //1225
    object HeavySnowDay : WeatherType(
        weatherDesc = "Heavy snow",
        imageRes = R.drawable.heavy_snow
    )
    object HeavySnowNight : WeatherType(
        weatherDesc = "Heavy snow",
        imageRes = R.drawable.heavy_snow
    )
    //1237
    object IcePelletsDay : WeatherType(
        weatherDesc = "Ice pellets",
        imageRes = R.drawable.ice_pellets
    )
    object IcePelletsNight : WeatherType(
        weatherDesc = "Ice pellets",
        imageRes = R.drawable.ice_pellets
    )
    //1240
    object LightRainShowerDay : WeatherType(
        weatherDesc = "Light rain shower",
        imageRes = R.drawable.patchy_light_rain
    )
    object LightRainShowerNight : WeatherType(
        weatherDesc = "Light rain shower",
        imageRes = R.drawable.patchy_light_rain_night
    )
    //1243
    object ModerateRainShowerDay : WeatherType(
        weatherDesc = "Moderate or heavy rain shower",
        imageRes = R.drawable.heavy_rain_shower
    )
    object ModerateRainShowerNight : WeatherType(
        weatherDesc = "Moderate or heavy rain shower",
        imageRes = R.drawable.heavy_rain_night
    )
    //1246
    object TorrentialSleetDay : WeatherType(
        weatherDesc = "Torrential rain shower",
        imageRes = R.drawable.heavy_rain_shower
    )
    object TorrentialSleetNight : WeatherType(
        weatherDesc = "Torrential rain shower",
        imageRes = R.drawable.heavy_rain_night
    )
    //1249
    object LightSleetShowerDay : WeatherType(
        weatherDesc = "Light sleet shower",
        imageRes = R.drawable.light_sleet
    )
    object LightSleetShowerNight : WeatherType(
        weatherDesc = "Light sleet shower",
        imageRes = R.drawable.light_sleet_night
    )
    //1252
    object ModerateSleetShowerDay : WeatherType(
        weatherDesc = "Moderate or heavy sleet showers",
        imageRes = R.drawable.light_sleet
    )
    object ModerateSleetShowerNight : WeatherType(
        weatherDesc = "Moderate or heavy sleet showers",
        imageRes = R.drawable.light_sleet_night
    )
    //1255
    object LightSnowShowerDay : WeatherType(
        weatherDesc = "Light snow showers",
        imageRes = R.drawable.light_snow_shower
    )
    object LightSnowShowerNight : WeatherType(
        weatherDesc = "Light snow showers",
        imageRes = R.drawable.patchy_snow_night
    )
    //1258
    object ModerateSnowShowerDay : WeatherType(
        weatherDesc = "Moderate or heavy snow showers",
        imageRes = R.drawable.light_snow_shower
    )
    object ModerateSnowShowerNight : WeatherType(
        weatherDesc = "Moderate or heavy snow showers",
        imageRes = R.drawable.patchy_snow_night
    )
    //1261
    object LightShowerIcePelletsDay : WeatherType(
        weatherDesc = "Light showers of ice pellets",
        imageRes = R.drawable.light_shower_pellets
    )
    object LightShowerIcePelletsNight : WeatherType(
        weatherDesc = "Light showers of ice pellets",
        imageRes = R.drawable.light_ice_pallets
    )
    //1264
    object ModerateShowerIcePelletsDay : WeatherType(
        weatherDesc = "Moderate or heavy showers of ice pellets",
        imageRes = R.drawable.heavy_shower_icepellets
    )
    object ModerateShowerIcePelletsNight : WeatherType(
        weatherDesc = "Moderate or heavy showers of ice pellets",
        imageRes = R.drawable.heavy_ice_pallets
    )
    //1273
    object PatchyLightRainThunderDay : WeatherType(
        weatherDesc = "Patchy light rain with thunder",
        imageRes = R.drawable.thunder_outbreak
    )
    object PatchyLightRainThunderNight : WeatherType(
        weatherDesc = "Patchy light rain with thunder",
        imageRes = R.drawable.rain_tstorm
    )
    //1276
    object ModerateRainTstormDay : WeatherType(
        weatherDesc = "Moderate or heavy rain with thunder",
        imageRes = R.drawable.heavy_rain_tstorm
    )
    object ModerateRainTstormNight : WeatherType(
        weatherDesc = "Moderate or heavy rain with thunder",
        imageRes = R.drawable.heavy_rain_tstorm
    )
    //1279
    object PatchySnowTstormDay : WeatherType(
        weatherDesc = "Patchy light snow with thunder",
        imageRes = R.drawable.patchy_snow_tstorm
    )
    object PatchySnowTstormNight : WeatherType(
        weatherDesc = "Patchy light snow with thunder",
        imageRes = R.drawable.snow_tstorm
    )
    //1282
    object ModerateSnowTstormDay : WeatherType(
        weatherDesc = "Moderate or heavy snow with thunder",
        imageRes = R.drawable.heavy_snow_tstorm
    )
    object ModerateSnowTstormNight : WeatherType(
        weatherDesc = "Moderate or heavy snow with thunder",
        imageRes = R.drawable.heavy_snow_tstorm
    )

    companion object{
        fun fromWeatherWeb(code: Int, isDay: Int): WeatherType{
            return if (isDay == 1) {
                when (code) {
                    1000 -> SunnyDay
                    1003 -> PartlyCloudyDay
                    1006 -> CloudyDay
                    1009 -> Overcast
                    1030 -> Mist
                    1063 -> PatchyRainDay
                    1066 -> PatchySnowDay
                    1069 -> PatchySleetDay
                    1072 -> PatchyFreezingDay
                    1087 -> ThunderyOutbreaksDay
                    1114 -> BlowingSnowDay
                    1117 -> BlizzardDay
                    1135 -> FogDay
                    1147 -> FreezingFogDay
                    1150 -> PatchyDrizzleDay
                    1153 -> LightDrizzleDay
                    1168 -> FreezingDrizzleDay
                    1171 -> HeavyFreezingDrizzleDay
                    1180 -> PatchyLightRainDay
                    1183 -> LightRainDay
                    1186 -> ModerateRainATDay
                    1189 -> ModerateRainDay
                    1192 -> HeavyRainATDay
                    1195 -> HeavyRainDay
                    1198 -> LightFreezingRainDay
                    1201 -> ModerateFreezingRainDay
                    1204 -> LightSleetDay
                    1207 -> ModerateSleetDay
                    1210 -> PatchyLightSnowDay
                    1213 -> LightSnowDay
                    1216 -> PatchyModerateSnowDay
                    1219 -> ModerateSnowDay
                    1222 -> PatchyHeavySnowDay
                    1225 -> HeavySnowDay
                    1237 -> IcePelletsDay
                    1240 -> LightRainShowerDay
                    1243 -> ModerateRainShowerDay
                    1246 -> TorrentialSleetDay
                    1249 -> LightSleetShowerDay
                    1252 -> ModerateSleetShowerDay
                    1255 -> LightSnowShowerDay
                    1258 -> ModerateSnowShowerDay
                    1261 -> LightShowerIcePelletsDay
                    1264 -> ModerateShowerIcePelletsDay
                    1273 -> PatchyLightRainThunderDay
                    1276 -> ModerateRainTstormDay
                    1279 -> PatchySnowTstormDay
                    1282 -> ModerateSnowTstormDay

                    else -> Overcast
                }
            } else {
                when (code) {
                    1000 -> ClearNight
                    1003 -> PartlyCloudyNight
                    1006 -> CloudyNight
                    1009 -> Overcast
                    1030 -> Mist
                    1063 -> PatchyRainNight
                    1066 -> PatchySnowNight
                    1069 -> PatchySleetNight
                    1072 -> PatchyFreezingNight
                    1087 -> ThunderyOutbreaksNight
                    1114 -> BlowingSnowNight
                    1117 -> BlizzardNight
                    1135 -> FogNight
                    1147 -> FreezingFogNight
                    1150 -> PatchyDrizzleNight
                    1153 -> LightDrizzleNight
                    1168 -> FreezingDrizzleNight
                    1171 -> HeavyFreezingDrizzleNight
                    1180 -> PatchyLightRainNight
                    1183 -> LightRainNight
                    1186 -> ModerateRainATNight
                    1189 -> ModerateRainNight
                    1192 -> HeavyRainATNight
                    1195 -> HeavyRainNight
                    1198 -> LightFreezingRainNight
                    1201 -> ModerateFreezingRainNight
                    1204 -> LightSleetNight
                    1207 -> ModerateSleetNight
                    1210 -> PatchyLightSnowNight
                    1213 -> LightSnowNight
                    1216 -> PatchyModerateSnowNight
                    1219 -> ModerateSnowNight
                    1222 -> PatchyHeavySnowNight
                    1225 -> HeavySnowNight
                    1237 -> IcePelletsNight
                    1240 -> LightRainShowerNight
                    1243 -> ModerateRainShowerNight
                    1246 -> TorrentialSleetNight
                    1249 -> LightSleetShowerNight
                    1252 -> ModerateSleetShowerNight
                    1255 -> LightSnowShowerNight
                    1258 -> ModerateSnowShowerNight
                    1261 -> LightShowerIcePelletsNight
                    1264 -> ModerateShowerIcePelletsNight
                    1273 -> PatchyLightRainThunderNight
                    1276 -> ModerateRainTstormNight
                    1279 -> PatchySnowTstormNight
                    1282 -> ModerateSnowTstormNight

                    else -> Overcast
            }
        }
            }

    }
}