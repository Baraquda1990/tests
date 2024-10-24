package com.example.lazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyrow.ui.theme.Gray
import com.example.lazyrow.ui.theme.LazyRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyRow (
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 30.dp)
                    .background(Gray)
            ){
                itemsIndexed(
                    listOf(
                        ItemRowModel(R.drawable.image_1,"Мерлин Монро"),
                        ItemRowModel(R.drawable.image_2,"Махатма Ганди"),
                        ItemRowModel(R.drawable.image_3,"Альберт Эйнштейн"),
                        ItemRowModel(R.drawable.image_4,"Томас Альфа Эдисон"),
                        ItemRowModel(R.drawable.image_5,"Алан Тьюринг"),
                        ItemRowModel(R.drawable.image_6,"Джулиус Роберт Опенгеймер")
                    )){
                        _,item->
                        ItemRow(item=item)
                    }

            }
        }
    }
}