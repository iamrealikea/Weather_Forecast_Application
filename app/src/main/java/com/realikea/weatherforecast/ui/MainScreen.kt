@file:OptIn(ExperimentalMaterial3Api::class)

package com.realikea.weatherforecast.ui

import android.Manifest
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realikea.weatherforecast.R
import com.realikea.weatherforecast.ui.theme.WeatherForecastTheme
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import com.realikea.weatherforecast.model.weather.AirQualityData
import com.realikea.weatherforecast.model.weather.LocationData
import com.realikea.weatherforecast.model.weather.WeatherData
import com.realikea.weatherforecast.model.weather.WeatherInfo
import com.realikea.weatherforecast.model.weather.WeatherType
import com.realikea.weatherforecast.model.weather.subtype.UsEpaIndex
import com.realikea.weatherforecast.model.weather.subtype.UvIndexType
import com.realikea.weatherforecast.model.weather.subtype.WindDirType
import com.realikea.weatherforecast.network.WeatherDataDto
import com.realikea.weatherforecast.ui.card.AqiCard
import com.realikea.weatherforecast.ui.card.FeelLikeCard
import com.realikea.weatherforecast.ui.card.HeaderData
import com.realikea.weatherforecast.ui.card.HumidityCard
import com.realikea.weatherforecast.ui.card.StatusBox
import com.realikea.weatherforecast.ui.card.UVindexCard
import com.realikea.weatherforecast.ui.card.VisibilityCard
import com.realikea.weatherforecast.ui.card.WindCard

@Composable
fun DataScreen(
    state: WeatherState,
    ){
    Column(modifier = Modifier
        .padding(start = 16.dp, top = 15.dp, end = 16.dp)
        .fillMaxWidth()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())
    ) {
        HeaderData(state = state,modifier = Modifier, color = MaterialTheme)
        //Spacer(Modifier.height(25.dp))
        Spacer(Modifier.height(14.dp))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier) {
                AqiCard(
                    modifier = Modifier,
                    color = MaterialTheme,
                    state = state,
                )
                Spacer(Modifier.height(20.dp))
                UVindexCard(modifier = Modifier, color = MaterialTheme, state = state)
                Spacer(Modifier.height(20.dp))
                VisibilityCard(state = state, modifier = Modifier)

            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier) {
                FeelLikeCard(modifier = Modifier,color = MaterialTheme, state = state)
                Spacer(Modifier.height(20.dp))
                HumidityCard(modifier = Modifier, color = MaterialTheme, state = state)
                Spacer(Modifier.height(20.dp))
                WindCard(state = state)
            }
        }
        StatusBox(modifier = Modifier, vertical = Alignment.Bottom, state = state)
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview(
){
    DataScreen(
        state = WeatherState(
            WeatherInfo(
            currentWeatherData = WeatherData(
                lastUpdated = "2024-01-23 20:30",
                airQualityData = AirQualityData(co = 1695.6, no2 = 63.1, o3 = 22.7, so2 = 14.4, pm2_5 = 47.0, pm10 = 71.7),
                code = 1003,
                feelslikeCelsius = 28.8,
                humidity = 70,
                isDay = 0,
                uv = 1.0,
                uvIndex = UvIndexType.fromWeatherWeb(uv = 1.0),
                weatherType = WeatherType.Overcast,
                temperatureCelsius = 28.0,
                usEpaIndex = 1,
                usEpaIndexType = UsEpaIndex.fromWeatherWeb(usEpaIndex = 1),
                windKph = 16.9,
                windDirType = WindDirType.W,
                visKM = 10.0
            ),
            currentLocationData = LocationData(
                country = "Thailand",
                localtime = "2024-01-23 20:34",
                name = "Pak Kret",
                region = "Nonthaburi"
            )
        )
        ))
}