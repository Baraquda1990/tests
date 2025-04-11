package com.example.a22_drawerlayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a22_drawerlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item2->Toast.makeText(this@MainActivity,"Item 2",Toast.LENGTH_SHORT).show()
                    R.id.item1->Toast.makeText(this@MainActivity,"Item 1",Toast.LENGTH_SHORT).show()
                }
                true
            }
            button.setOnClickListener{
                drawer.openDrawer(GravityCompat.START)
            }
            }

        }
    }
