package com.example.recyclerview_kotlin

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
            pendenciaAdapter.run {
                pendencias.add(0, pendencia {
                    nome = "Orientadores"
                    pendencia = "Novas tarefas designadas"
                })
                notifyItemInserted(0)
            }
            //rola a pagina para a posição zero depois que a pendencia foi adicionada
            recycler_view_main.scrollToPosition(0)
        }

    }
}
