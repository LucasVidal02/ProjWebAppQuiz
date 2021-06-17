package com.example.projwebapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        imageButton1.setOnClickListener{
            var intent = Intent(this, Perguntas::class.java)

            startActivity(intent)
            finish()
        }
    }
}