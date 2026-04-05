package com.example.prnvdemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var screen by remember { mutableStateOf(1) }
    var name by remember { mutableStateOf("") }

    when (screen) {

        // 🔹 Screen 1: Welcome
        1 -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome 👋", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { screen = 2 }) {
                    Text("Start")
                }
            }
        }

        // 🔹 Screen 2: Input
        2 -> {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Enter your name")
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Enter your name") }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { screen = 3 }) {
                    Text("Submit")
                }
            }
        }

        // 🔹 Screen 3: Result
        3 -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Hello $name 🎉", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}