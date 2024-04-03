package com.example.test6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //var nameList= listOf("sddf","afsfe","asefed")
        var nameList=ArrayList<String>()
        nameList.add("Пигор")
        nameList.add("Питя")
        nameList.add("Питор")
        nameList.add("Пиворг")
        nameList.add("Питва")
        nameList.add("Пидра")

        //var llist:TextView?=null
        //llist=findViewById(R.id.listView)
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,nameList)
        listView.adapter=adapter
        listView.setOnItemClickListener{parent,view,positin,id ->
            Toast.makeText(this,"Pressed item position:${nameList.get(position)}",Toast.LENGTH_SHORT).show()
        }
    }
}