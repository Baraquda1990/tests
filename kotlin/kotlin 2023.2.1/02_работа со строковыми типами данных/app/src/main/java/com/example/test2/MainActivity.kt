package com.example.test2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var number:Int=6
    private var number2:Int=6
    //Можно делать форматированые строки
    //private var text:String="В магазине осталось $number яблоков"

    //Можно результат функции конкатенировать
    //private var text:String="В магазине осталось ${getNumber()} яблоков"

    private var text:String="В магазине осталось 123 <яблоков> и 321 <персиков>"

    private var tvText:TextView?=null
    private var tvText2:TextView?=null


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
        tvText2=findViewById(R.id.tvText2)
        //Можно вызвать функцию и приводить результат в строку
        //tvText?.setText(getNumber().toString())

        val subText:String=text.substringAfter("<")
        val subText2:String=subText.substringBefore(">")
        tvText?.setText(subText2)

        val ss:String=text.substringAfterLast("<").substringBefore(">")
        tvText2?.setText(ss)


    }
    private fun getNumber():Int{
        return number+number2
    }
}