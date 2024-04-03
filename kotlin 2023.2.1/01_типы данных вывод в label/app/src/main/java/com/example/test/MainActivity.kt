package com.example.test

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var number:Byte=5
    private var number1:Short=32
    private var number2:Int=0
    private var number3:Long=0
    private var numberF:Float=0.0f
    private var numberD:Double=0.0
    private var text:String="awerfwqerf qwerf qwef"
    private var ch:Char='f'

    private var tvText:TextView?=null
    private var counter:Int=0
    private var start:Boolean=false
    private var main:ConstraintLayout?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        tvText=findViewById(R.id.tvText)
        main=findViewById(R.id.main)

        Thread{
            start=true
            while(start){
                Thread.sleep(1000)
                runOnUiThread{
                    if(counter==5) main?.setBackgroundColor(Color.BLUE)
                    tvText?.setText(counter.toString())
                    counter++}
            }
        }.start()


    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        start=false
    }
}