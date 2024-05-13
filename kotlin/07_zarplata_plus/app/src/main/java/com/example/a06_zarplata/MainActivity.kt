package com.example.a06_zarplata

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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
            bindingClass.img.visibility=View.VISIBLE
            var name:String=bindingClass.textBox.text.toString()
            var label=bindingClass.label
            var pass=bindingClass.pass.text.toString()
            when(name){
                Constance.DVORNIC->{
                    if(pass==Constance.DVORNIC_PASS) {
                        bindingClass.img.setImageResource(R.drawable.face_co_1)
                        label.text="Твоя зп ${Constance.DVORNIC_ZP}тг. Нищеброд!"
                    }
                    else {
                        bindingClass.img.setImageResource(R.drawable.dula)
                        label.text="Не тот порол"
                    }
                }
                Constance.ZAMDIR->{
                    if(pass==Constance.ZAMDIR_PASS) {
                        bindingClass.img.setImageResource(R.drawable.face_co_2)
                        label.text="Получи свои ${Constance.ZAMDIR_ZP}тг. ЗамДир ебаный!!"
                    }
                    else {
                        bindingClass.img.setImageResource(R.drawable.dula)
                        label.text="Не тот порол"
                    }
                }
                Constance.AKIM->{
                    if(pass==Constance.AKIM_PASS) {
                        bindingClass.img.setImageResource(R.drawable.face_co_2)
                        label.text="Твоя зп. ${Constance.AKIM_ZP}тг. Аким ворующий у народа. Ирод, сука, тварь, паскуда!!!"
                    }
                    else {
                        bindingClass.img.setImageResource(R.drawable.dula)
                        label.text="Не тот порол"
                    }
                }
                Constance.PRESIDENT->{
                    if(pass==Constance.PRESIDENT_PASS) {
                        bindingClass.img.setImageResource(R.drawable.face_co_2)
                        label.text="Здравтсвуйте ГОСПОДИН Владимирович!"
                    }
                    else {
                        bindingClass.img.setImageResource(R.drawable.dula)
                        label.text="Не тот порол"
                    }
                }

                else->{
                    bindingClass.img.setImageResource(R.drawable.dula)
                    label.text="Я тебя не знаю."
                }
            }
        }
    }
}