package com.dsc.compose.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home", fontSize = 34.sp)
        Button(onClick = { navController.navigate("search") }) {
            Text(text = "Go to search")
        }
    }
}