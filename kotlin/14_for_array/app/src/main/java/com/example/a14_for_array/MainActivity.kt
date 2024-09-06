package com.example.a14_for_array

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val lostArray= arrayOf(10000,2300,45000,65000,6500,400)
    val earnArray= arrayOf(15000,300,345000,5000,16500,3400)
    val resultArray=ArrayList<String>()
    fun _oncreate1(){
        val names=resources.getStringArray(R.array.names)
        for((index,name) in names.withIndex()){
            resultArray.add("Имя: $name - прибыль = ${earnArray[index]-lostArray[index]}")
            Log.d("MtLog","Статистика -/- ${resultArray[index]}")
        }
    }
    fun _oncreate2(){
            val bad = 0..3
            val normal = 4..6
            val nice = 7..9
            val excellent = 10
            val gradeArray = arrayOf(4, 7, 3, 6, 10, 2)
            val nameArray = arrayOf("Антон", "Егор", "Маша", "Светлана", "Юля", "Семен")
            val badArray = ArrayList<String>()
            val normalArray = ArrayList<String>()
            val niceArray = ArrayList<String>()
            val excellentArray = ArrayList<String>()
        for ((index, grade) in gradeArray.withIndex()) {
            if (grade in bad) badArray.add("Ученик: ${nameArray[index]} – $grade")
            if (grade in normal) normalArray.add("Ученик: ${nameArray[index]} – $grade")
            if (grade in nice) niceArray.add("Ученик: ${nameArray[index]} – $grade")
            if (grade == excellent) excellentArray.add("Ученик: ${nameArray[index]} – $grade")
        }
        badArray.forEach(){
            Log.d("MyLog",it)
        }
        normalArray.forEach(){
            Log.d("MyLog",it)
        }
        niceArray.forEach(){
            Log.d("MyLog",it)
        }
        excellentArray.forEach(){
            Log.d("MyLog",it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _oncreate2()
    }
}