@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.realikea.weatherforecast

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
//import com.realikea.weatherforecast.ui.DataScreen
import com.realikea.weatherforecast.ui.HeaderData
import com.realikea.weatherforecast.ui.HumidityCard

import com.realikea.weatherforecast.ui.UVindexCard
import com.realikea.weatherforecast.ui.WeatherViewModel
import com.realikea.weatherforecast.ui.aqiEx
import com.realikea.weatherforecast.ui.feelLikeEx
import com.realikea.weatherforecast.ui.theme.WeatherForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by this.viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
            setContent {
                WeatherForecastTheme {
                        Box(modifier = Modifier.fillMaxSize()){
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
                                        feelLikeEx(modifier = Modifier,color = MaterialTheme, state = viewModel.state)
                                        HumidityCard(modifier = Modifier, color = MaterialTheme, state = viewModel.state)
                                    }
                                }
                            }
                            if(viewModel.state.isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            viewModel.state.error?.let { error ->
                                Text(
                                    text = error,
                                    color = Color.Red,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }

                }
            }
        }
}


/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherForecastTheme {
        val viewModel: WeatherViewModel by this.viewModels()
        DataScreen(state = viewModel.state)
    }
}
*/