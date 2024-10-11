package com.example.a25_cristal_ball

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt=findViewById(R.id.txt)
    }
    fun click(view:View){
        txt.text=get_string()
    }
    fun get_rand():Int{
        var rand:Int
        rand=resources.getStringArray(R.array.array_string).size-1
        return (0..rand).random()
    }
    fun get_string():String{
        var str:String=resources.getStringArray(R.array.array_string)[get_rand()]
        return str
    }

}