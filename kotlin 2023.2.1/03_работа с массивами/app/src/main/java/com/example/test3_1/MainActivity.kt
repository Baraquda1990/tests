package com.example.test3_1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*var mass= arrayOf(0,5,4,8,3)
        for (n in 0 until mass.size){
            mass[n]=12
            println(mass[n])
        }*/

//пример цикла
        /*for(n in 0..10){
            println(n)
            //Log.d("MyLog","N is : "+n) //Пример логирования
        }*/

//Примеры создания массивов
//var mass=Array(5){}
//var mass:Array<Int>=arrayOf(2,5,6)
//var mass =IntArray(3){4}


        var text:String="<Я> тот <кто> вечно <хочет> зла и вечно совершает <благо>"
        var counter:Int=0
        for(n in 0..text.length-1){
            if(text.get(n)== '<') counter++
        }
        println("counter"+counter)

        var startNumber=IntArray(counter)
        var endNumber=IntArray(counter)
        var startPcounter:Int=0
        var endPcounter:Int=0
        println("len"+text.length)
        for(n in 0 until text.length){
            if(text.get(n)=='<'){
                startNumber[startPcounter]=n
                startPcounter++
                println("start"+startPcounter)
            }
            if(text.get(n)=='>'){
                endNumber[endPcounter]=n
                endPcounter++
            }
        }
        var str_mass=Array(counter){""}
        for(n in 0 until startNumber.size) {
            str_mass[n]=text.substring(startNumber[n],endNumber[n])
            Log.d("MyLog",str_mass[n])
        }

    }
}