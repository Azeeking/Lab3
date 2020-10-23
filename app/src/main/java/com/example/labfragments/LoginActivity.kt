package com.example.labfragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHRED_PREF", Context.MODE_PRIVATE)

    }

    fun onClick(view: View){
        when(view.id){
             R.id.loginbtn -> openFragment()
        }
    }

    fun openFragment(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}

