package com.satyajitbiswal.crypto.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.satyajitbiswal.crypto.R

// Set of Material typography styles to start with

private val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold),
    Font(R.font.poppins_extralight),
    Font(R.font.poppins_italic),
    Font(R.font.poppins_light),
    Font(R.font.poppins_thin),
    Font(R.font.poppins_semibold),
)

val typography = Typography(
    titleLarge = TextStyle(
        fontFamily = poppins,
        fontSize = 34.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppins,
        fontSize = 24.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = poppins,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = poppins,
        fontSize = 16.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = poppins
    )

)