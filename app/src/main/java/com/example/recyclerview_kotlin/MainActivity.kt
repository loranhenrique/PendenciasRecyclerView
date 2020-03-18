package com.example.recyclerview_kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.recyclerview_kotlin.model.minhasPendencias
import com.example.recyclerview_kotlin.model.pendencia
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lazy funciona de forma preguiçosa, de forma que só inicializa a property
    //na primeira vez que for utilizada, nas proximas vezes que usar, o valor é atribuido e
    //devolvido imediatamente
    private val pendenciaAdapter by lazy {
        PendenciaAdapter(minhasPendencias())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //dando um get/set no adapter
        recycler_view_main.adapter = pendenciaAdapter
        //para a construção de listas verticais
        recycler_view_main.layoutManager = LinearLayoutManager(this)

        //ação do botão FAB(FloatingActionButton) quando clicado
        //adiciona essa nova pendencia
        fab.setOnClickListener {
            val i: Intent = Intent(this, NovaPendencia::class.java)
            startActivity(i)
        }

        val nv_nome: String? = intent.getStringExtra("nv_nome")
        val nv_pendencia: String? = intent.getStringExtra("nv_pendencia")

        if (nv_nome != null && nv_pendencia != null) {
            recycler_view_main.run {
                pendenciaAdapter.pendencias.add(0, pendencia {
                    nome = nv_nome
                    pendencia = nv_pendencia
                })
                recycler_view_main.scrollToPosition(0)
            }
        }

    }
}
