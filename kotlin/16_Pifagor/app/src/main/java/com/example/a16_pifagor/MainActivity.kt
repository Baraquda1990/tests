package com.example.a16_pifagor

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a16_pifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickRezult(view: View){
        if(!isFieldEmpty()){
            val rez=getString(R.string.rezult_info)+getRezult()
            binding.tvRezult.text=rez
        }
    }
    private fun isFieldEmpty():Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error="Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edB.error="Поле должно быть заполнено"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    private fun getRezult():String{
        binding.apply {
            val a=edA.text.toString().toDouble()
            val b=edB.text.toString().toDouble()
            val c= sqrt( a.pow(2)+b.pow(2) )
            return c.toString()
        }
    }
}