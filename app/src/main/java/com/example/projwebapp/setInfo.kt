package com.example.projwebapp

object setInfo {

    const val nome:String="nome"
    const val pontuação:String="pontuação"

    fun getPergunta(): ArrayList<InfoPerguntas> {
        var p: ArrayList<InfoPerguntas> = arrayListOf()

        var pergunta1 = InfoPerguntas(
            "Como funcionam os telefones nos aviões?",
            1,
            "Via satélite",
            "Por ondas de rádio",
            "Por ondas mecânicas",
            "N.D.A",
            1
        )
        var pergunta2 = InfoPerguntas(
            "Qual dessas empresas é brasileira?",
            2,
            "Boeing",
            "Airbus",
            "Embraer",
            "Cesna",
            3
        )
        var pergunta3 = InfoPerguntas(
            "Qual a companhia aérea mais antiga em atividade",
            3,
            "Gol",
            "Air France",
            "Americam Airlines",
            "KLM",
            4
        )
        var pergunta4 = InfoPerguntas(
            "Quantos KM aproximadamente um avião pode planar após perder seus motores?",
            4,
            "30 KM",
            "10 KM",
            "100 KM",
            "320 KM",
            3
        )
        var pergunta5 = InfoPerguntas(
            "Quem inventou o avião",
            5,
            "Santos Dumond",
            "Irmãos Wright",
            "Louis Blériot",
            "Otto Lilienthal",
            1
        )
        p.add(pergunta1)
        p.add(pergunta2)
        p.add(pergunta3)
        p.add(pergunta4)
        p.add(pergunta5)
        return p
    }
}


