package com.realikea.weatherforecast.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realikea.weatherforecast.R
import com.realikea.weatherforecast.model.weather.AirQualityData
import com.realikea.weatherforecast.model.weather.LocationData
import com.realikea.weatherforecast.model.weather.WeatherData
import com.realikea.weatherforecast.model.weather.WeatherInfo
import com.realikea.weatherforecast.model.weather.WeatherType
import com.realikea.weatherforecast.model.weather.subtype.UsEpaIndex
import com.realikea.weatherforecast.model.weather.subtype.UvIndexType
import com.realikea.weatherforecast.model.weather.subtype.WindDirType
import com.realikea.weatherforecast.ui.WeatherState

@Composable
fun HumidityCard(state: WeatherState, modifier: Modifier, color: MaterialTheme){
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            modifier = Modifier
                .width(170.dp)
                .height(151.dp)
        ) {
            Column() {
                Text(
                    text = stringResource(R.string.humidity_title),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.headlineSmall,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Image(
                        painter = painterResource(R.drawable.humidity),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${data.humidity}%",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun HumidityPreview(
){
    HumidityCard(modifier = Modifier,color = MaterialTheme,
        state = WeatherState(
            WeatherInfo(
                currentWeatherData = WeatherData(
                    lastUpdated = "2024-01-23 20:30",
                    airQualityData = AirQualityData(co = 1695.6, no2 = 63.1, o3 = 22.7, so2 = 14.4, pm2_5 = 47.0, pm10 = 71.7),
                    code = 1003,
                    feelslikeCelsius = 28.8,
                    humidity = 100,
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