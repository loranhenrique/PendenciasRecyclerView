package com.example.recyclerview_kotlin.model

class Pendencia(var nome: String = "", var pendencia: String = "") {

        companion object {

            val nome: String = ""
            val pendencia: String = ""

            fun build(): Pendencia {
                var pendencias: Pendencia =
                    Pendencia()

                pendencias.nome = this.nome
                pendencias.pendencia = pendencia

                return  pendencias
            }
        }
}