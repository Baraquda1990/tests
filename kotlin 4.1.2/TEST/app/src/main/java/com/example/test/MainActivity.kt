package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var t: TextView
    lateinit var b: Button
    var s:String="Stroka"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        t=findViewById(R.id.textView)
        b=findViewById(R.id.button)
        b.setOnClickListener{
            t.text="Это работает!!!"
            if(s.endsWith("ka") && s.startsWith("St")){
                Log.d("Logi","Работает!!! Уррраааа!!!")
            }
        }
    }
}