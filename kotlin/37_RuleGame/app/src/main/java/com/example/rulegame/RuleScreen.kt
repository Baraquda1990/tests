package com.example.rulegame

import android.util.Log
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rulegame.ui.theme.Red
import com.example.rulegame.ui.theme.White

@Composable
fun RuleScreen() {
    var rotationValue by remember {
        mutableStateOf(0f)
    }
    var number by remember {
        mutableStateOf(0)
    }
    val angle: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearOutSlowInEasing
        ),
        finishedListener = {
            val index = (365f - (rotationValue % 360f)) / (360f / ValueList.list.size)
            Log.d("MyLog", "index: ${index}")
            number = ValueList.list[index.toInt()]
        }
    )
    Log.d("MyLog", "angle: $angle")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = number.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentWidth()
                .wrapContentHeight(),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.ruleta),
                contentDescription = "Ruleta",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle)
            )
            Image(
                painter = painterResource(id = R.drawable.flecha),
                contentDescription = "Arrow",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {
                rotationValue = ((0..360).random().toFloat() + 720) + angle
            },
            colors = ButtonDefaults.run { val buttonColors = buttonColors(Red)
                buttonColors
            }
        ) {
            Text(
                text = "Start",
                color = Color.White
            )
        }
    }
}