package com.example.projwebapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_perguntas.*

class Perguntas : AppCompatActivity() {

    private var nome:String?=null
    private var pontuação:Int=0

    private var currentPosition:Int=1
    private var perguntasList:ArrayList<InfoPerguntas>?=null
    private var selectOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        nome=intent.getStringExtra(setInfo.nome)

        setInfo.getPergunta()

        perguntasList=setInfo.getPergunta()
        setPergunta()

        op_1.setOnClickListener{
            selectedOpStyle(op_1,1)
        }
        op_2.setOnClickListener{
            selectedOpStyle(op_2,2)
        }
        op_3.setOnClickListener{
            selectedOpStyle(op_3,3)
        }
        op_4.setOnClickListener{
            selectedOpStyle(op_4,4)
        }

        responder.setOnClickListener {
            if(selectOption!=0){
                val pergunta=perguntasList!![currentPosition-1]
                if(selectOption!=pergunta.correto){
                    setCor(selectOption, R.drawable.opcao_pergunta_errada)

                }else{
                    pontuação++;
                }
                setCor(pergunta.correto,R.drawable.opcao_pergunta_certa)
                if(currentPosition==perguntasList!!.size)

                    responder.text="Resultado"
                else{
                    responder.text="Próxima Pergunta"
                }

            }else{
                currentPosition++
                when{
                    currentPosition<=perguntasList!!.size->{
                        setPergunta()

                    }
                    else->{
                        var intent=Intent(this, Resultado::class.java)

                        intent.putExtra(setInfo.nome,nome.toString())
                        intent.putExtra(setInfo.pontuação,pontuação.toString())
                        intent.putExtra("Tamanho Total",perguntasList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }

                }
            }
            selectOption=0
        }

    }
    fun setCor(op:Int,color:Int){
        when(op){
            1->{
                op_1.background=ContextCompat.getDrawable(this, color)
            }
            2->{
                op_2.background=ContextCompat.getDrawable(this, color)
            }
            3->{
                op_3.background=ContextCompat.getDrawable(this, color)
            }
            4->{
                op_4.background=ContextCompat.getDrawable(this, color)
            }
        }
    }

    fun setPergunta(){
        val pergunta = perguntasList!![currentPosition-1]
        progressBar.progress=currentPosition
        progressBar.max=perguntasList!!.size
        progress_text.text="${currentPosition}"+"/"+"${perguntasList!!.size}"
        texto_pergunta.text=pergunta.pergunta
        op_1.text=pergunta.opcao_um
        op_2.text=pergunta.opcao_dois
        op_3.text=pergunta.opcao_tres
        op_4.text=pergunta.opcao_quatro

    }

    fun setOpStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,op_1)
        optionList.add(1,op_2)
        optionList.add(2,op_3)
        optionList.add(3,op_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("black"))
            op.background=ContextCompat.getDrawable(this,R.drawable.opcao_pergunta)
            op.typeface= Typeface.DEFAULT

        }
    }

    fun selectedOpStyle(view:TextView,op:Int){
        setOpStyle()
        selectOption=op
        view.background=ContextCompat.getDrawable(this,R.drawable.opcao_pergunta_selected)
        view.typeface= Typeface.DEFAULT
        view.setTextColor(Color.parseColor("#000000"))

    }
}