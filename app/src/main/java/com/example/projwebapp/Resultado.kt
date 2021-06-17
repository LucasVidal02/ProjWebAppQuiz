package com.example.projwebapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val  nome=intent.getStringExtra(setInfo.nome)
        val pontuação=intent.getStringExtra(setInfo.pontuação)
        val perguntasTotais=intent.getStringExtra("Tamanho Total")

        textView2.text="Parabéns ${nome}"
        pontuacao.text="${pontuação} / ${perguntasTotais}"
        buttonfinal.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}