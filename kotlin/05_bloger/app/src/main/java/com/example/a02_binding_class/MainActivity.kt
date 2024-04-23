package com.example.a02_binding_class

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a02_binding_class.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.but.setOnClickListener {
            var txt:Int=bindingClass.txt.text.toString().toInt()
            when(txt){
                in 1..1000->{
                    bindingClass.tvRez.visibility=View.VISIBLE
                    bindingClass.tvRez.text="Ты мелкий ублюдок"
                }
                in 1000..100000->{
                    bindingClass.tvRez.visibility=View.VISIBLE
                    bindingClass.tvRez.text="Ты средний чмошник"
                }
                in 100000..10000000->{
                    bindingClass.tvRez.visibility=View.VISIBLE
                    bindingClass.tvRez.text="Ты кругой гавнюк"
                }
                else->{
                    bindingClass.tvRez.visibility=View.VISIBLE
                    bindingClass.tvRez.text="Охуеть, ты гэнгстер, епт бля"
                }
            }
        }



    }
}