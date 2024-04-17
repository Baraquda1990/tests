package com.example.a04_if_when

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a04_if_when.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    val maxPerson=90
    val currentPerson=35
    fun variant1(){
        bindingClass.but.setOnClickListener {
            if (maxPerson > currentPerson)
                bindingClass.tv.text = "Все в порядке"
            else
                bindingClass.tv.text = "Превышено максимальное количество посетителей"
        }
    }
    fun variant2(){
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=if (maxPerson > currentPerson)
                "Все в порядке"
            else
                "Превышено максимальное количество посетителей"
        }
    }
    fun variant3(){
        bindingClass.but.setOnClickListener {
            if (maxPerson < currentPerson) {
                bindingClass.tv.text = "Все в порядке"
                bindingClass.tv.setBackgroundColor(Color.GREEN)
            } else {
                bindingClass.tv.text = "Превышено максимальное количество посетителей"
                bindingClass.tv.setBackgroundColor(Color.RED)
            }
        }
    }
    fun variant4(){
        bindingClass.but.setOnClickListener {
            when(currentPerson){
                in 0..maxPerson -> bindingClass.tv.text="Все в порядке"
                91 -> bindingClass.tv.text = "Число 91"
                92 ->bindingClass.tv.text="Число 92"
                93 -> bindingClass.tv.text="Число 93"
            }
        }
    }
    fun variant5(){
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=when(currentPerson){
                in 0..maxPerson -> "Все в порядке"
                else -> "Предел превышен"
            }
        }
    }
    fun variant6(){
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=when(currentPerson){
                !in 0..maxPerson -> "Предел превышен"
                else -> "Все в порядке"
            }
        }
    }
    fun variant7(){
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=when(currentPerson){
                90,92,95 -> "Предел превышен"
                else -> "Все в порядке"
            }
        }
    }
    fun variant8(){
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=when(maxPerson>currentPerson){
                true -> "Все в порядке"
                false -> "Предел превышен"
            }
        }
    }
    fun variant9(){
        var text="опасность"
        var text2="все в порядке"
        var text3="не понятно"
        bindingClass.but.setOnClickListener {
            bindingClass.tv.text=when("опасность"){
                text -> "Все в порядке"
                text2 -> "Предел превышен"
                else -> "не понятно"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        variant9()


    }
}