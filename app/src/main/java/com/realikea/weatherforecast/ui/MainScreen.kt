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

@Composable
fun HeaderData(
    modifier: Modifier,
    state: WeatherState
){ state.weatherInfo?.currentWeatherData?.let{ data ->
        Row() {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = modifier.padding()
            ) {
                Text(
                    text = "${data.temperatureCelsius}C",
                    style = MaterialTheme.typography.displayLarge
                )
                Text(
                    text = "kys",
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "High 38° Low 28°",
                    style = MaterialTheme.typography.displaySmall
                )

            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.sunny),
                contentDescription = null,
                modifier = Modifier
                    .width(109.dp)
                    .height(109.dp)
            )
        }
    }

}

class nowWeatherIcon(){

}

@Composable
fun aqiEx(modifier: Modifier, color: MaterialTheme){
    var expanded: Boolean? by rememberSaveable { mutableStateOf<Boolean?>(false) }
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(151.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .padding(bottom = 14.dp)
            .alpha(1f)
            .clickable {
                expanded = true
            }
    ) {
        Column {
            Text(
                text = "AQI",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineSmall,

                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, bottom = 6.dp)
                    .width(67.dp)
                    .height(18.dp)
                    .alpha(1f)
            )
            Text(
                text = "149",
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.None,
                style = MaterialTheme.typography.titleLarge,

                overflow = TextOverflow.Ellipsis,
                modifier = Modifier

                    .width(182.dp)
                    .height(49.dp)
            )
            AnimatedVisibility(expanded == true) {
                Text(
                    text = "bad air quality",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.None,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(179.dp)
                        .height(37.dp)
                )
            }

        }
    }

}

@Composable
fun feelLikeEx(state: WeatherState,modifier: Modifier, color: MaterialTheme){
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            modifier = Modifier
                .width(170.dp)
                .height(89.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 9.dp, topEnd = 9.dp, bottomStart = 9.dp, bottomEnd = 9.dp
                    )
                )
                .padding(bottom = 14.dp)
        ) {
            Column {
                Text(
                    text = "Feel Like",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.None,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                        .alpha(1f)
                )
                Text(
                    text = "40º",
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration = TextDecoration.None,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
fun UVindexCard(modifier: Modifier, color: MaterialTheme){
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(151.dp)
    ){
        Column {
            Text(
                text = stringResource(R.string.uv_index_title),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, bottom = 6.dp)
                    .width(67.dp)
                    .height(18.dp)
                    .alpha(1f),

                )
            Text(
                text = stringResource(R.string.uv_number),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(182.dp)
                    .height(49.dp),
            )
            Text(
                text = stringResource(R.string.uv_level),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(182.dp)
            )
        }
    }
}

@Composable
fun HumidityCard(state: WeatherState,modifier: Modifier, color: MaterialTheme){
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
                        .padding(start = 10.dp, top = 10.dp, bottom = 6.dp)
                        .alpha(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start)
                {
                    /*
                    Image(
                        painter = painterResource(TODO()),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                        //.align(Alignment.CenterVertically)
                    )*/
                    Text(
                        text = stringResource(R.string.humidity_percentage)
                    )
                }
            }
        }
    }
}


/*@Composable
fun DataScreen(state: WeatherState){
    Column(modifier = Modifier
        .padding(start = 16.dp, top = 15.dp, end = 16.dp)) {
        HeaderData(state = viewModel.state,modifier = Modifier)
        Spacer(Modifier.height(25.dp))
        Spacer(Modifier.height(14.dp))
        Row() {
            Column(modifier = Modifier) {
                aqiEx(
                    modifier = Modifier,
                    color = MaterialTheme,
                )
                UVindexCard(modifier = Modifier, color = MaterialTheme)

            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier) {
                feelLikeEx(modifier = Modifier,color = MaterialTheme)
                HumidityCard(modifier = Modifier, color = MaterialTheme, state = viewModel.state)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherForecastTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DataScreen(state = viewModel.state)
        }
    }
}*/