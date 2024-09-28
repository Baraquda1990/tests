package com.example.a21_bottomnavigationview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a21_bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            bNav.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item1->{Toast.makeText(this@MainActivity,"Item1",Toast.LENGTH_SHORT).show()}
                    R.id.item2->{Toast.makeText(this@MainActivity,"Item2",Toast.LENGTH_SHORT).show()}
                    R.id.item3->{Toast.makeText(this@MainActivity,"Item3",Toast.LENGTH_SHORT).show()}
                    R.id.item4->{Toast.makeText(this@MainActivity,"Item4",Toast.LENGTH_SHORT).show()}
                }
                true
            }
        }
    }
}