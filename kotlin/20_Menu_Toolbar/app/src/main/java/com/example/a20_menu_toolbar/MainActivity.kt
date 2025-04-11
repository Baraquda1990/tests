package com.example.a20_menu_toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Admin"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home-> finish()
            R.id.delete->{
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show()
            }
            R.id.save->{
                Toast.makeText(this,"Save",Toast.LENGTH_SHORT).show()
            }
            R.id.sync->{
                Toast.makeText(this,"Sync",Toast.LENGTH_SHORT).show()
            }
            R.id.search->{
                Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}
