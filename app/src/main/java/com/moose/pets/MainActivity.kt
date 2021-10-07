package com.moose.pets

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val viewmodel: MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Form() }
    }

    @Composable
    private fun Form(){
        val email by viewmodel.email.observeAsState("")
        val loading by viewmodel.loading.observeAsState(false)
        val text by viewmodel.numbers.collectAsState(initial = 0)

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Number is $text", style = MaterialTheme.typography.h5)
            Input(email = email, onChanged = { viewmodel.changeEmail(it) })
            Button(onClick = { viewmodel.changeLoading(!loading) }) {
                if (loading)
                    Icon(Icons.Default.Send, contentDescription = "loading")
                else
                    Text("Submit")
            }
        }
    }

    // After state hoisting
    @Composable
    private fun Input(email: String, onChanged: (value: String) -> Unit){
        OutlinedTextField(
            value = email,
            onValueChange = onChanged,
            modifier = Modifier.padding(0.dp, 10.dp),
            label = { Text("Your email address") }
        )
    }
}