package com.example.a08_recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a08_recyclerview.databinding.ActivityEditBinding
import com.example.a08_recyclerview.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding:ActivityEditBinding
    private var indexImage=0
    private var imageId=R.drawable.plane1
    private val imageIdList= listOf(
        R.drawable.plane1,
        R.drawable.plane2,
        R.drawable.plane3,
        R.drawable.plane4,
        R.drawable.plane5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButtons()
    }
    private fun initButtons()=with(binding){
        nextImg.setOnClickListener {
            indexImage+=1
            if(indexImage>imageIdList.size-1) indexImage=0
            imageId=imageIdList[indexImage]
            imageView2.setImageResource(imageId)
            done.setOnClickListener {
                val plant=Plains(imageId,edTitle.text.toString(),edDesc.text.toString())
                val editIntent= Intent().apply{
                    putExtra("plant",plant)
                }
                setResult(RESULT_OK,editIntent)
                finish()
            }
        }
    }
}