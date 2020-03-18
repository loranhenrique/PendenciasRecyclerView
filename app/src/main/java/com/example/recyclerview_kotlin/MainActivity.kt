package com.example.recyclerview_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.recyclerview_kotlin.model.Pendencia
import com.example.recyclerview_kotlin.model.minhasPendencias
import com.example.recyclerview_kotlin.model.pendencia
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pendenciaAdapter by lazy {
        PendenciaAdapter(minhasPendencias())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_main.adapter = pendenciaAdapter
        recycler_view_main.layoutManager = LinearLayoutManager(this)


        fab.setOnClickListener {
            pendenciaAdapter.pendencias.add(0, pendencia {
                nome = "Teste"
                pendencia = "Teste"
            })
            pendenciaAdapter.notifyItemInserted(0)
            recycler_view_main.scrollToPosition(0)
        }

    }
}
