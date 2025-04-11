package com.example.a29_jetpack_compose_android_card_box_image

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a29_jetpack_compose_android_card_box_image.ui.theme._29_Jetpack_Compose_Android_Card_Box_ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (modifier = Modifier.verticalScroll(rememberScrollState())){
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
                ListCompost("Zack Efron","actor")
            }
        }
    }
}

@Composable
fun ListCompost(name:String,prof:String){
    var counter= remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp)
            //.pointerInput(Unit) {
            //    detectHorizontalDragGestures { change, dragAmount ->
            //        Log.d("MyLog","Horizontal Drag $dragAmount")
            //    }
            //}
                /*detectTapGestures {
                    Log.d("MyLog","Long press $it")
                }
                //detectDragGesturesAfterLongPress { change, dragAmount ->
                //    Log.d("MyLog","Long press $dragAmount")
                //}
            }*/
            .clickable {
            //Log.d("MyLog","Clicked")
                counter.value+=1
        },
        shape = RoundedCornerShape(15.dp),
        //elevation = 5.dp
    )
    {
        Box(
            //modifier = Modifier.fillMaxSize(),
            //contentAlignment = Alignment.Center
        )
        {
            Row (
                verticalAlignment = Alignment.CenterVertically
            )
            { Image(
                painter = painterResource(R.drawable.i),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(5.dp).size(64.dp).clip(CircleShape)
            )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(name)
                    Text(prof)
                    Text(counter.value.toString())
                }
            }
        }
    }
}
