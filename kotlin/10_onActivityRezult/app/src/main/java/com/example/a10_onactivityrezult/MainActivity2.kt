package com.example.a10_onactivityrezult

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a10_onactivityrezult.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass=ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)

        val message=intent.getStringExtra("name")
        bindingClass.textView2.text="Привет $message \n Введи свой возраст"
    }
    fun onClick(view: View){
        intent.putExtra("old",bindingClass.editTextText.text.toString())
        setResult(RESULT_OK,intent)
        finish()
    }
}