package com.example.a11_avtorization

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.a11_avtorization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var signState=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState=intent.getStringExtra(Constance.SIGN_STATE)!!
        if(signState==Constance.SIGN_IN_STATE){
            bindingClass.edName1.visibility=View.GONE
            bindingClass.edName2.visibility=View.GONE
            bindingClass.edName3.visibility=View.GONE
            bindingClass.bAvatar.visibility=View.INVISIBLE
        }else if(signState==Constance.SIGN_UP_STATE){
            bindingClass.edName1.visibility=View.VISIBLE
            bindingClass.edName2.visibility=View.VISIBLE
            bindingClass.edName3.visibility=View.VISIBLE
            bindingClass.bAvatar.visibility=View.VISIBLE
        }
    }
    fun onClickDone(view: View){
        if(signState==Constance.SIGN_UP_STATE) {
            intent.putExtra(Constance.LOGIN,bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD,bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME1,bindingClass.edName1.text.toString())
            intent.putExtra(Constance.NAME2,bindingClass.edName2.text.toString())
            intent.putExtra(Constance.NAME3,bindingClass.edName3.text.toString())
            if(bindingClass.imAvatar.isVisible) intent.putExtra(Constance.AVATAR_ID,R.drawable.face_co_1)
            setResult(RESULT_OK,intent)
            finish()
        }else if(signState==Constance.SIGN_IN_STATE){
            intent.putExtra(Constance.LOGIN,bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD,bindingClass.edPassword.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }
    fun clickAvatar(view: View){
        bindingClass.imAvatar.visibility=View.VISIBLE
        bindingClass.imAvatar.setImageResource(R.drawable.face_co_1)
    }
}