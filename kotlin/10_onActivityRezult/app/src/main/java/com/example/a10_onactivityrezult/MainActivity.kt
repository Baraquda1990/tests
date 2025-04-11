package com.example.a10_onactivityrezult

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a10_onactivityrezult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode==RESULT_OK && data!=null){
            bindingClass.textView.text=data.getStringExtra("old")
        }
    }
    fun onButtonClick(view: View){
        var name=bindingClass.edText.text.toString()
        var i=Intent(this,MainActivity2::class.java)
        i.putExtra("name",name)
        startActivityForResult(i,100)
    }
}