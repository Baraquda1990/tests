package com.example.a08_recyclerview

import android.media.Image.Plane
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a08_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val adapter=PlaneAdapter()
    private val imageIdList= listOf(R.drawable.plane1,
        R.drawable.plane2,
        R.drawable.plane3,
        R.drawable.plane4,
        R.drawable.plane5)
    private var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager=GridLayoutManager(this@MainActivity,3)
            rcView.adapter=adapter
            button.setOnClickListener{
                if(index>4) index=0
                val plant=Plains(imageIdList[index],"Plain $index")
                adapter.addPlant(plant)
                index+=1
            }
        }
    }
}