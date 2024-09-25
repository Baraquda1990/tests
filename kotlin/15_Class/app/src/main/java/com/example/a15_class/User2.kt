package com.example.a15_class

import android.util.Log

class User2 (var name:String,var id:String, var age:Int){
    fun addAge(years:Int){
        age=age.plus(years)
    }
    fun printUserInfo(){
        Log.d("Mylog","User name: $name , id: $id , age: $age")
    }
}