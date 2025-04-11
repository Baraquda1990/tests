package com.example.weatherapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Tab
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherModel
import com.example.weatherapp.ui.theme.LightBlue
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun MainCard(currentDay: MutableState<WeatherModel>,onClickSync:()->Unit,onClickSearch:()->Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
            colors= CardColors(
                containerColor= LightBlue,
                contentColor = Color.White,
                disabledContentColor = LightBlue,
                disabledContainerColor = LightBlue
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            shape = RoundedCornerShape(10.dp),
        //border = BorderStroke(width = 3.dp, Color.Gray)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    modifier = Modifier.padding(top=8.dp,start=8.dp),
                    text=currentDay.value.time,
                    style= TextStyle(fontSize = 15.sp),
                    color= Color.White
                )
                AsyncImage(
                    model="https:"+currentDay.value.icon,
                    contentDescription = "im",
                    modifier = Modifier.size(35.dp)
                        .padding(top = 3.dp,end=8.dp)
                )
            }
            Text(
                text=currentDay.value.city,
                style= TextStyle(fontSize = 24.sp),
                color= Color.White
            )
            Text(
                text=if(currentDay.value.currentTemp.isNotEmpty()){
                    currentDay.value.currentTemp.toFloat().toInt().toString()+"C"
                }else{currentDay.value.maxTemp.toFloat().toInt().toString() +
                        "ºC/${currentDay.value.minTemp.toFloat().toInt()}ºC"},
                style= TextStyle(fontSize = 65.sp),
                color= Color.White
            )
            Text(
                text=currentDay.value.condition,
                style= TextStyle(fontSize = 16.sp),
                color= Color.White
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                IconButton(
                    onClick = {
                        onClickSearch.invoke()
                    }
                ) {
                    Icon(
                        painter = painterResource(id=R.drawable.search),
                        contentDescription = "123"
                        //tint=Color.White
                    )
                }
                Text(
                    text="${currentDay.value
                        .maxTemp.toFloat().toInt()}C/${currentDay
                        .value.minTemp.toFloat().toInt()}C",
                    style= TextStyle(fontSize = 16.sp),
                    color= Color.White
                )
                IconButton(
                    onClick = {
                        onClickSync.invoke()
                    }
                ) {
                    Icon(
                        painter = painterResource(id=R.drawable.sync),
                        contentDescription = "123",
                        //tint=Color.White
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class,
    ExperimentalMaterial3Api::class
)
@Preview (showBackground = true)
@Composable
fun TabLayout(daysList:MutableState<List<WeatherModel>>,currentDay: MutableState<WeatherModel>){
    val tabList= listOf("HOURS","DAYS")
    var state by remember { mutableStateOf(0)}
    var state_page = rememberPagerState(pageCount={2})
    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = Modifier.padding(5.dp).clip(RoundedCornerShape(5.dp))
    ){
        PrimaryTabRow(
            selectedTabIndex = state,
            containerColor = LightBlue,
            contentColor = Color.White
        ){
            tabList.forEachIndexed { index, s ->
                Tab(
                    selected=state==index,
                    onClick = {
                        state=index
                        when(state) {
                            0 -> coroutineScope.launch {
                                // Call scroll to on pagerState
                                state_page.animateScrollToPage(0)
                            }

                            1 -> coroutineScope.launch {
                                // Call scroll to on pagerState
                                state_page.animateScrollToPage(1)
                            }
                        }
                              },
                    text = { Text(text = s, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }
        HorizontalPager(
            state=state_page
        ) {
            page->
                val list=when(page){
                    0-> getWeatherByHours(currentDay.value.hours)
                    1->daysList.value
                    else->daysList.value
                }
            MainList(list,currentDay)
        }
    }
}

private fun getWeatherByHours(hours: String): List<WeatherModel>{
    if (hours.isEmpty()) return listOf()
    val hoursArray = JSONArray(hours)
    val list = ArrayList<WeatherModel>()
    for (i in 0 until hoursArray.length()){
        val item = hoursArray[i] as JSONObject
        list.add(
            WeatherModel(
                "",
                item.getString("time"),
                item.getString("temp_c").toFloat().toInt().toString() + "ºC",
                item.getJSONObject("condition").getString("text"),
                item.getJSONObject("condition").getString("icon"),
                "",
                "",
                ""
            )
        )
    }
    return list
}

