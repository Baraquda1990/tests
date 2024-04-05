package com.example.test4

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import java.util.TimerTask

class MainActivity : Activity() {

    var image_view:ImageView?=null
    var imageArray:IntArray= intArrayOf(R.drawable.semafor_red,R.drawable.semafor_yellow,R.drawable.semafor_green)
    var flag:Boolean=false
    var counter:Int=0
    var timer: Timer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        image_view=findViewById(R.id.imageView)

    }
    fun click_button(view:View){
        view as ImageView
        flag = if(!flag){
            on_off()
            view.setImageResource(R.drawable.button_on)
            true
        }else{
            counter=0
            image_view?.setImageResource(R.drawable.semafor_gray)
            view.setImageResource(R.drawable.button_off)
            timer?.cancel()
            false
        }
    }

    fun on_off(){
        timer=Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread{
                counter++
                if(counter==3) counter=0
                    Log.d("mylog",counter.toString())
                image_view?.setImageResource(imageArray[counter])}
            }
        }, 0,1000)
    }


}