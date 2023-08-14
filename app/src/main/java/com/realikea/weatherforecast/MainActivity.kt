@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.realikea.weatherforecast

import android.os.Bundle
import android.widget.ExpandableListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.realikea.weatherforecast.ui.theme.WeatherForecastTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherForecastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainPage()
                }
            }
        }
    }
}

@Composable
fun mainPage() {
Column(modifier = Modifier
    .padding(start = 16.dp, top = 15.dp, end = 16.dp)) {
    navigationDrawer()
    HeaderData(modifier = Modifier)
    hourlyForecast(
        modifier = Modifier,
        color = MaterialTheme
    )
    Row() {
        Column(modifier = Modifier) {
            aqiEx(
                modifier = Modifier,
                color = MaterialTheme
            )
            feelLikeEx(modifier = Modifier,color = MaterialTheme)
        }
        Column(modifier = Modifier.padding(start = 5.dp)) {
            aqiEx(
                modifier = Modifier,
                color = MaterialTheme
            )
            feelLikeEx(modifier = Modifier,color = MaterialTheme)
        }
    }

}
}

@Composable
fun navigationDrawer(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        }
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { scope.launch { drawerState.open() } }) {
                    Text("Click to open")
                }
            }
        }
    )
}


@Composable
private fun HeaderData(modifier: Modifier){
    val image = painterResource(R.drawable.sunny)
    Row() {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier.padding()
        ) {
            Text(
                text = stringResource(R.string.temp),
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.place_location),
                fontWeight = FontWeight.Bold,
                fontSize = 42.sp
            )
            Text(
                text = "High 38° Low 28°",
                fontSize = 24.sp
            )

        }
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 6.dp)
                .width(109.dp)
                .height(109.dp)
        )
    }

}

@Composable
private fun hourlyForecast(modifier: Modifier, color: MaterialTheme){
    Box(
        modifier = Modifier
            .width(380.dp)
            .height(152.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp
                )
            )
            .padding(top = 0.dp, bottom = 0.dp)
            .alpha(1f)
            .horizontalScroll(rememberScrollState()),
        )
}

@Composable
private fun aqiEx(modifier: Modifier, color: MaterialTheme){
    var expanded: Boolean? by rememberSaveable { mutableStateOf<Boolean?>(false) }
    Card(
        modifier = Modifier
            .width(179.dp)
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
            fontSize = 14.sp,
            textDecoration = TextDecoration.None,

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
            fontSize = 36.sp,
            textDecoration = TextDecoration.None,

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
fun feelLikeEx(modifier: Modifier, color: MaterialTheme){
    Card(
        modifier = Modifier
            .width(179.dp)
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
            fontSize = 32.sp,
            textDecoration = TextDecoration.None,

            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
    }
}

@Composable
private fun HourlyData(time : String, temp : String){
   Column() {
       Text(text = time)
       Text(text = temp)
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherForecastTheme {
        mainPage()
    }
}