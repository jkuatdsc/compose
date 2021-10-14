package com.dsc.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dsc.compose.R

private val Montserrat = FontFamily(
    Font(R.font.bold, FontWeight.Bold),
    Font(R.font.light, FontWeight.Light),
    Font(R.font.regular, FontWeight.Normal)
)

val typography = Typography(
    h5 = TextStyle(
        fontSize = 20.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
    ),
    caption = TextStyle(
        fontSize = 14.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
    ),
    body1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        fontSize = 16.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal
    )
)