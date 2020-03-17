package com.example.recyclerview_kotlin.model

data class Pendencia(val nome: String,
                     val pendencia: String
)

fun minhasPendencias(): MutableList<Pendencia> = mutableListOf(
    Pendencia(
        nome = "Loran",
        pendencia = "Projetinho"
    ),
    Pendencia (
        nome = "Mateus",
        pendencia = "Orientador"
    ),
    Pendencia (
        nome = "Luciano",
        pendencia = "Orientador"
    )
)
