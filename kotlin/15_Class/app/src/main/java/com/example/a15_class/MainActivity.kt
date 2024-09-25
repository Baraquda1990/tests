package com.example.a15_class

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user1=User()
        var user2=User2("Sergey","000000",25)
        var user3=User2("Andrey","12121212",32)
        user1.id="000000"
        user2.addAge(10)
        user3.addAge(5)

        user2.printUserInfo()
        user3.printUserInfo()
    }
}