package com.dsc.compose.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

/**
 * primary color will be used for common UI components like Buttons and Icons.
 *
 * secondary color will be used for Fabs, Links and headlines.
 *
 * surface color will be used for large UI components like cards
 *
 * background color will be the background for activities
 * */


// Light theme colors
val light = lightColors(
    primary = Color(0xff2874a6),
    surface = Color(0xffffffff),
    onSurface = Color(0xff17202a),
    secondary = Color(0xff004977),
    background = Color(0xffffffff),
    onBackground = Color(0xff17202a),
)

// Dark theme colors
val dark = darkColors(
    primary = Color(0xff2c3e50),
    surface = Color(0xff001120),
    onSurface = Color(0xfffbfcfc),
    secondary = Color(0xff526172),
    background = Color(0xff001120),
    onBackground = Color(0xfffbfcfc),
)