package com.example.a02_binding_class

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a02_binding_class.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    val a=324
    val b=34


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        bindingClass=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        bindingClass.textView.text="Its work"
        bindingClass.b2.setOnClickListener{
            bindingClass.tv4.visibility=View.GONE
            Log.d("Log",View.GONE.toString())
        }
        bindingClass.add.setOnClickListener {
            var rezult=a+b
            bindingClass.tvRezult.text="Результат сложения:$rezult"
        }
        bindingClass.sub.setOnClickListener {
            var rezult=a-b
            bindingClass.tvRezult.text="Результат вычитания:$rezult"
        }
        bindingClass.mul.setOnClickListener {
            var rezult=a*b
            bindingClass.tvRezult.text="Результат умноженния:$rezult"
        }
        bindingClass.div.setOnClickListener {
            var rezult=a/b
            bindingClass.tvRezult.text="Результат деления:$rezult"
        }


    }
}