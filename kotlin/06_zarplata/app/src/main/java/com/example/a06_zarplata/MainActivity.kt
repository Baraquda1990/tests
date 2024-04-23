package com.example.a06_zarplata

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_zarplata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        super.onCreate(savedInstanceState)

        bindingClass.but.setOnClickListener {
            var name:String=bindingClass.textBox.text.toString()
            var label=bindingClass.label
            label.text=when(name){
                "Олег"->"Твоя зп 200 000тг. Нищеброд!"
                "Василий"->"Получи свои 500 000тг. ЗамДир ебаный!!"
                "Николай"->"Твоя зп. 1 000 000тг. Аким ворующий у народа. Ирод, сука, тварь, паскуда!!!"
                "Владимир"->"Здравтсвуйте ГОСПОДИН Владимирович!"
                else->"Я тебя не знаю."
            }
        }

    }
}