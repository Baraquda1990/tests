package com.example.a07_to_next_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_to_next_activity.databinding.ActivityMain2Binding
import com.example.a07_to_next_activity.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClick(view: View){
        val i=Intent()
        val text=binding.editTextText.text.toString()
        i.putExtra("key1",text)
        setResult(RESULT_OK,i)
        finish()
    }
}