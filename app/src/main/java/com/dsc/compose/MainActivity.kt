package com.dsc.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dsc.compose.ui.theme.ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Card(modifier = Modifier.size(200.dp).padding(10.dp), elevation = 10.dp) {
                            Column(verticalArrangement = Arrangement.SpaceAround) {
                                Text("Some razzle dazzle!")
                                Button(onClick = { /*TODO*/ }) {
                                    Text("Click me")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}