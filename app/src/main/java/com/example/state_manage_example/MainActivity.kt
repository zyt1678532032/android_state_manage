package com.example.state_manage_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.state_manage_example.ui.theme.State_manage_exampleTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            State_manage_exampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val counter by remember { viewModel.counter }
                    val state = viewModel.counterFlow.collectAsState()

                    Column {
                        Button(
                            onClick = viewModel::increase
                        ) {
                            Text(
                                modifier = Modifier,
                                text = "点击 counter by state: $counter",
                            )
                        }

                        Button(
                            onClick = viewModel::increaseByFlow
                        ) {
                            Text(
                                modifier = Modifier,
                                text = "点击 counter by flow: ${state.value}",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    State_manage_exampleTheme {
        Greeting("Android")
    }
}