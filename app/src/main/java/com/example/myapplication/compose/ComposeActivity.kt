package com.example.myapplication.compose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Karthik")
        }
    }
}


@Composable
fun MessageCard(name: String) {
    Column {
        Text(text = name)
        Text(text = "KD")
        Text(text = "Hello $name!")
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard("Test Preview")
}
