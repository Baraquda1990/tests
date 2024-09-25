package com.example.a07_to_next_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_to_next_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private var launcher:ActivityResultLauncher<Intent>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            rezult:ActivityResult->
               if(rezult.resultCode==RESULT_OK){
                   val text= rezult.data?.getStringExtra("key1")
                   binding.apply {
                       textView.text=text
                   }
               }
        }
    }
    fun onClick(view: View){
        launcher?.launch(Intent(this,MainActivity2::class.java))
    }
}