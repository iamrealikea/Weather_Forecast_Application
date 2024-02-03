package com.realikea.weatherforecast.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.realikea.weatherforecast.R
import com.realikea.weatherforecast.ui.WeatherState

@Composable
fun StatusBox(modifier: Modifier,vertical: Alignment.Vertical,state: WeatherState) {
    state.weatherInfo?.currentLocationData?.let { data ->
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(R.drawable.weatherapi_logo),
                contentDescription = "Weather api logo",
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Update ${ data.localtime }",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}