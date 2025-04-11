package com.example.weatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.json.JSONObject

const val API_KEY:String="eb0f6ea06fdd48cfabb104904241610"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "London",
                        modifier = Modifier.padding(innerPadding),
                        context = this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,context:Context) {
    val state= remember {
        mutableStateOf("London")
    }
    Column (modifier = Modifier.fillMaxSize()){
        Box(
            modifier=Modifier.fillMaxHeight(0.5f).fillMaxWidth()
                .background(color= Color.Red),
            contentAlignment = Alignment.Center
        ){
            Text(text="Temp in $name = ${state.value}")
        }
        Box(
            modifier=Modifier.fillMaxHeight().fillMaxWidth()
                .background(color=Color.Blue),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                onClick = {
                    getResalt(name,state,context)
                },modifier=Modifier.padding(5.dp)
                    .fillMaxWidth()
            ) {
                Text("Refresh")
            }
        }
    }
}

private fun getResalt(city:String,state:MutableState<String>,context: Context){
    val url="https://api.weatherapi.com/v1/current.json"+
            "?key=$API_KEY"+
            "&q=$city"+
            "&aqi=no"
    Log.d("MyLog", url)
    //val url="https://google.com"
    //val url="https://api.weatherapi.com/v1/current.json?key=eb0f6ea06fdd48cfabb104904241610&q=London&aqi=no"
    val queue=Volley.newRequestQueue(context)
    val stringRequest=StringRequest(
        Request.Method.GET,
        url,
        {
            response->
            val obj=JSONObject(response)
            state.value=obj.getJSONObject("current").getString("temp_c")
        },
        {
            error->
            Log.d("MyLog",error.toString()+"Error: $error "+"$url")
        }
    )
    queue.add(stringRequest)
}