package com.example.a11_avtorization

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.a11_avtorization.databinding.ActivityMain2Binding
import com.example.a11_avtorization.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass: ActivityMain2Binding
    private var login:String="empty"
    private var password:String="empty"
    private var name:String="empty"
    private var name2:String="empty"
    private var name3:String="empty"
    private var avatar_image_id:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass=ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==Constance.SIGN_IN_KEY){
            val l=data?.getStringExtra(Constance.LOGIN)
            val p=data?.getStringExtra(Constance.PASSWORD)
            if(login==l && password==p){
                bindingClass.imAvatar.setImageResource(avatar_image_id)
                val text_info="$name $name2 $name3"
                bindingClass.tv.text=text_info
            }else{
                bindingClass.imAvatar.setImageResource(R.drawable.dula)
                bindingClass.tv.text="Нет аккаунта"
            }
        }else if(requestCode==Constance.SIGN_UP_KEY){
            login=data?.getStringExtra(Constance.LOGIN).toString()
            password=data?.getStringExtra(Constance.PASSWORD).toString()
            name=data?.getStringExtra(Constance.NAME1).toString()
            name2=data?.getStringExtra(Constance.NAME2).toString()
            name3=data?.getStringExtra(Constance.NAME3).toString()
            avatar_image_id=data?.getIntExtra(Constance.AVATAR_ID,0)!!
            bindingClass.imAvatar.setImageResource(avatar_image_id)
            val text_info="$name $name2 $name3"
            bindingClass.tv.text=text_info
            bindingClass.signUp.visibility=View.GONE
            bindingClass.singIn.text="Выйти"

        }
    }
    fun on_click_sign_in(view: View){
        if(bindingClass.imAvatar.isVisible && bindingClass.tv.text.toString()!="Нет аккаунта"){
            bindingClass.tv.text=""
            bindingClass.imAvatar.visibility=View.INVISIBLE
            bindingClass.signUp.visibility=View.VISIBLE
            bindingClass.singIn.text=getString(R.string.sing_in)
        }else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.SIGN_IN_KEY)
        }
    }
    fun on_click_sign_out(view: View){
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE,Constance.SIGN_UP_STATE)
        startActivityForResult(intent,Constance.SIGN_UP_KEY)
    }
}
