package com.dsc.compose.features.notifications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Notifications(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Notifications", fontSize = 34.sp)
    }
}