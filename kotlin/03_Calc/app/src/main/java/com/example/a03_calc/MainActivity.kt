package com.example.a03_calc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a03_calc.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingClass=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        var value1:Int? = null
        var value2:Int? = null
        var value_string:String=""
        bindingClass.rez.text=""
        bindingClass.but0.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="0"
            }else{
                bindingClass.rez.text=txt.toString()+"0"
            }
        }
        bindingClass.but1.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="1"
            }else{
                bindingClass.rez.text=txt.toString()+"1"
            }
        }
        bindingClass.but2.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="2"
            }else{
                bindingClass.rez.text=txt.toString()+"2"
            }
        }
        bindingClass.but3.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="3"
            }else{
                bindingClass.rez.text=txt.toString()+"3"
            }
        }
        bindingClass.but4.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="4"
            }else{
                bindingClass.rez.text=txt.toString()+"4"
            }
        }
        bindingClass.but5.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="5"
            }else{
                bindingClass.rez.text=txt.toString()+"5"
            }
        }
        bindingClass.but6.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="6"
            }else{
                bindingClass.rez.text=txt.toString()+"6"
            }
        }
        bindingClass.but7.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="7"
            }else{
                bindingClass.rez.text=txt.toString()+"7"
            }
        }
        bindingClass.but8.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="8"
            }else{
                bindingClass.rez.text=txt.toString()+"8"
            }
        }
        bindingClass.but9.setOnClickListener {
            val txt=bindingClass.rez.text
            if(value2!=null){
                value1=null
                value2=null
                bindingClass.rez.text="9"
            }else{
                bindingClass.rez.text=txt.toString()+"9"
            }
        }
        bindingClass.butpluz.setOnClickListener {
            if (value1 == null) {
                value_string=bindingClass.rez.text.toString()
                value1 = value_string.toInt()
                bindingClass.rez.text=""
            }else{
                value_string=bindingClass.rez.text.toString()
                value2=value_string.toInt()
                bindingClass.rez.text=(value1!! + value2!!).toString()
            }

            }


        }



    }

