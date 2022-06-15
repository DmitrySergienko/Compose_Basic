package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme() {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp(names: List<String> = listOf("World", "Compose","Any")) {
        Column {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

    @Composable
    private fun Greeting(name: String) {

        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                OutlinedButton(
                    onClick = { /* TODO */ }
                ) {
                    Text("Show more")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeBasicTheme {
            MyApp()
        }
    }
}