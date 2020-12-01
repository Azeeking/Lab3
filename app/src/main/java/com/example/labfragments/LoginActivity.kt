package com.example.labfragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("user", "")
        if (user!!.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View){
        val username = login.text.toString()
        val password = password.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()){
            val user = User(username,password)
            val editor = sharedPreferences.edit()
            val userJson = Gson().toJson(user)
            editor.putString("user", userJson)
            editor.apply()
            when(view.id){
                R.id.loginbtn -> openFragment()
            }
        }

    }

    fun openFragment(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}

