package com.example.a08_recyclerview

import android.content.Intent
import android.media.Image.Plane
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a08_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val adapter=PlaneAdapter()
    private var editLauncher:ActivityResultLauncher<Intent>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        editLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode== RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plains)
            }
        }
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager=GridLayoutManager(this@MainActivity,3)
            rcView.adapter=adapter
            button.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity,EditActivity::class.java))
            }
        }
    }
}