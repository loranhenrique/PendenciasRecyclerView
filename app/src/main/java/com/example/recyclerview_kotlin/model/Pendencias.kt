package com.example.recyclerview_kotlin.model

import java.util.*

class Pendencias {
    companion object{

        fun MinhasPendencias(): MutableList<Pendencia> {
            return Arrays.asList(
                Pendencia.build().also { pendencia ->
                    pendencia.nome = "Loran"
                    pendencia.pendencia = "Terminar esse app"
                },

                Pendencia.build().also { pendencia ->
                    pendencia.nome = "Lucas"
                    pendencia.pendencia = "Realizar uma task"
                }
            )
        }
    }
}