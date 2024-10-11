package com.example.a26_countdowntimer

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txt:TextView
    private lateinit var button:Button
    private var timer:CountDownTimer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt=findViewById(R.id.txt)
        button=findViewById(R.id.Start_button)
    }
    fun start_button(view: View){
        StartCountDownTimer(20000)
    }
    private fun StartCountDownTimer(ms:Long){
        timer=object:CountDownTimer(ms,1){
            override fun onTick(millisUntilFinished: Long) {
                txt.text=millisUntilFinished.toString()
            }

            override fun onFinish() {
                txt.text="Finish"
            }

        }.start()
    }
}