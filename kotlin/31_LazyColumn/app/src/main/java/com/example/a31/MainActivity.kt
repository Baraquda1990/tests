package com.example.a31

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a31.ui.theme._31Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //LC()
            //LC2()
            LC3()
        }
    }
}

@Composable
fun LC(){
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier.fillMaxSize()
    ) {
        items(count=100) {
            Text(text="Item $it", fontSize = 30.sp, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}
@Composable
fun LC2(){
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            listOf("Item1","Item2","Item3","End","Finish")
        ) {index,item->
            Text(text="Index $index : $item", fontSize = 30.sp, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}
@Composable
fun LC3(){
    LazyRow (
        verticalAlignment = Alignment.CenterVertically,
        modifier=Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            listOf("Item1","Item2","Item3","End","Finish")
        ) {index,item->
            Text(text="Index $index : $item", fontSize = 30.sp, modifier = Modifier.padding(horizontal = 10.dp))
        }
    }
}