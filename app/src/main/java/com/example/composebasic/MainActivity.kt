package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
    fun MyApp() {

        // TODO: This state should be hoisted
        var shouldShowOnboarding by rememberSaveable{ mutableStateOf(true) }

        if (shouldShowOnboarding) {
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()

        }
    }

    @Composable
    fun Greetings(names: List<String> = List(100) { "$it" }) {
        Column(modifier = Modifier.padding(4.dp)) {
            LazyColumn {
                items(names) { name ->
                    Greeting(name)
                }
            }
        }
    }


    @Composable
    private fun Greeting(name: String) {
        var expanded by remember { mutableStateOf(false) }
        val extraPadding = if (expanded) 47.dp else 0.dp

        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {

                    Text(text = "Hello, ")
                    Text(text = name)
                }
                OutlinedButton(onClick = { expanded = !expanded })
                {
                    Text(if (expanded) "Show more" else "show less")
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)

    @Composable
    fun DefaultPreview() {
        ComposeBasicTheme {
            MyApp()
        }
    }
}




