package com.realikea.weatherforecast.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.realikea.weatherforecast.R

val IBMPlexMono = FontFamily(
    Font(R.font.ibmplexmono_regular),
    Font(R.font.ibmplexmono_bold, FontWeight.Bold)
)
val IBMPlexSans = FontFamily(
    Font(R.font.ibmplexsans_medium),
    Font(R.font.ibmplexsans_bold, FontWeight.Bold)
)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = IBMPlexMono,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp
    ),
    displayMedium = TextStyle(
        fontFamily = IBMPlexMono,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    displaySmall = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    titleLarge = TextStyle(
        fontFamily = IBMPlexMono,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    titleMedium = TextStyle(
        fontFamily = IBMPlexMono,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = IBMPlexMono,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    )
)