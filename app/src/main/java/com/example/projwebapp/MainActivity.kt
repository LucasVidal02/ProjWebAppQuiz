package com.example.projwebapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonProx.setOnClickListener{
            if(inputName.text.toString().isEmpty()){
                Toast.makeText(this, "Coloque seu nome", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this, Menu::class.java)
                intent.putExtra("${setInfo.nome}", inputName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}


