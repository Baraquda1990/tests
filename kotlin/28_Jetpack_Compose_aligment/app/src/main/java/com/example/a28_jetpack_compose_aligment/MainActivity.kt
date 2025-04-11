package com.example.a28_jetpack_compose_aligment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.a28_jetpack_compose_aligment.ui.theme._28_Jetpack_Compose_aligmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            get_compost()
        }
    }
}
@Preview (showBackground = true)
@Composable
fun get_compost(){
    Row (modifier = Modifier.background(Color.Gray).fillMaxWidth().fillMaxHeight(0.5f)) {
        Column (modifier = Modifier.background(Color.Red).fillMaxWidth(0.5f).fillMaxHeight(0.85f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text("123")
        Text("123")
        Text("123")
    }
        Column (modifier = Modifier.background(Color.Blue).fillMaxWidth().fillMaxHeight(0.85f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text("321")
            Text("321")
            Text("321")
        }
    }
}