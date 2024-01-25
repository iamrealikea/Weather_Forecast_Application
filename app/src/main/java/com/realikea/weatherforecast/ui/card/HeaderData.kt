package com.realikea.weatherforecast.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.realikea.weatherforecast.ui.WeatherState

@Composable
fun HeaderData(
    modifier: Modifier,
    state: WeatherState,
    color: MaterialTheme
){
    state.weatherInfo?.currentWeatherData?.let{ data ->
        Row() {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = modifier.padding()
            ) {
                Text(
                    text = "${data.temperatureCelsius}°",
                    style = MaterialTheme.typography.displayLarge,
                )
                Text(
                    text = "${data.weatherType.weatherDesc}",
                    style = MaterialTheme.typography.displayMedium
                )
                locationName(state = state)

            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = data.weatherType.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .width(109.dp)
                    .height(109.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
@Composable
fun locationName(state: WeatherState){
    state.weatherInfo?.currentLocationData?.let { data ->
        Column {
            Text(
                text = data.name,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = "${data.region}",
                style = MaterialTheme.typography.displaySmall
            )
            Text(text = "${data.country}",style = MaterialTheme.typography.displaySmall)
        }
    }
}