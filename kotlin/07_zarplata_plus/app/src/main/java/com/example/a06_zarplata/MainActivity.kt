package com.example.a06_zarplata

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            var pass=bindingClass.pass.text.toString()
            when(name){
                Constance.DVORNIC->{
                    if(pass==Constance.DVORNIC_PASS) label.text="Твоя зп ${Constance.DVORNIC_ZP}тг. Нищеброд!"
                        else label.text="Не тот порол"}
                Constance.ZAMDIR->{
                    if(pass==Constance.ZAMDIR_PASS) label.text="Получи свои ${Constance.ZAMDIR_ZP}тг. ЗамДир ебаный!!"
                    else label.text="Не тот порол"}
                Constance.AKIM->{
                    if(pass==Constance.AKIM_PASS) label.text="Твоя зп. ${Constance.AKIM_ZP}тг. Аким ворующий у народа. Ирод, сука, тварь, паскуда!!!"
                    else label.text="Не тот порол"}
                Constance.PRESIDENT->{
                    if(pass==Constance.PRESIDENT_PASS) label.text="Здравтсвуйте ГОСПОДИН Владимирович!"
                    else label.text="Не тот порол"}
                else->label.text="Я тебя не знаю."
            }
        }
    }
}