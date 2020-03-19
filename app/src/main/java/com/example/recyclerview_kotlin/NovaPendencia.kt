package com.example.recyclerview_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerview_kotlin.model.minhasPendencias
import com.example.recyclerview_kotlin.model.pendencia
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nova_pendencia.*
import java.util.ArrayList

class NovaPendencia : AppCompatActivity() {

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_pendencia)

        bt_enviar.setOnClickListener {
            val nv_nome = et_nome.text.toString()
            val nv_pendencia = et_pendencia.text.toString()
            val list_pende = novasPended(nv_nome, nv_pendencia, index)
            val i = Intent(this, MainActivity::class.java)
            i.putStringArrayListExtra("nv_pendencia", list_pende)
            startActivity(i)
        }

        bt_cancelar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    fun novasPended(nome: String, pendencia: String, index: Int): ArrayList<String> {

        val list_nv_pendencias: ArrayList<String> = ArrayList()
        val pendencias = intent.getStringArrayListExtra("pendencias")

        if (pendencias != null) {
            for (i in pendencias.indices step 2) {
                list_nv_pendencias.add(this.index, pendencias[i])
                list_nv_pendencias.add(this.index + 1, pendencias[i + 1])
                this.index = i + 2
            }

            list_nv_pendencias.add(this.index, nome)
            list_nv_pendencias.add(this.index + 1, pendencia)
        } else {
            //caso não tenha nenhuma pendencia nova sem a lista padrão
            list_nv_pendencias.add(index, nome)
            list_nv_pendencias.add(index + 1, pendencia)
        }

        return list_nv_pendencias
    }
}
