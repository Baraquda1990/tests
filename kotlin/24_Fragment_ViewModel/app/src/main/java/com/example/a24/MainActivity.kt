package com.example.a24

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel:DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment.newInstance(),R.id.frame1)
        openFrag(BlankFragment2.newInstance(),R.id.frame2)

        dataModel.message_to_activity.observe(this, {
            binding.textView.text=it
        })
    }
    private fun openFrag(f:Fragment,id_holder:Int){
        supportFragmentManager
            .beginTransaction()
            .replace(id_holder,f)
            .commit()
    }
}