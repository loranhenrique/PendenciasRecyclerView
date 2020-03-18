package com.example.recyclerview_kotlin.model

data class Pendencia(val nome: String,
                     val pendencia: String
)

//PendenciaBuilder me proporciona editar os campos de Pendencia
class PendenciaBuilder {
    var nome: String = ""
    var pendencia: String = ""

    //como o nome diz eu construo algo, no caso, uma nova pendencia a partir das variaveis da PendenciaBuilder
    fun build() : Pendencia = Pendencia(nome,pendencia)
}

//Me proporciona conseguir adicionar novos itens em Pendencias,
//usado quando clico no botão fab para adicionar pendencia nova
fun pendencia(block: PendenciaBuilder.() -> Unit): Pendencia = PendenciaBuilder().apply(block).build()

//gera uma lista de pendências padrão
fun minhasPendencias(): MutableList<Pendencia> = mutableListOf(
    Pendencia(
        nome = "Loran Henrique Teixeira",
        pendencia = "Adicionar pendências novas"
    ),
    Pendencia (
        nome = "Loran Henrique Teixeira",
        pendencia = "Criar tela para pendência"
    ),
    Pendencia (
        nome = "Loran Henrique Teixeira",
        pendencia = "Editar as pendências"
    )
)
