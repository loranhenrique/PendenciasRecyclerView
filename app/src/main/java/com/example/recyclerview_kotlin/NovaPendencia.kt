package com.example.recyclerview_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_kotlin.model.minhasPendencias
import com.example.recyclerview_kotlin.model.pendencia
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nova_pendencia.*

class NovaPendencia : AppCompatActivity() {

    private val pendenciaAdapter by lazy {
        PendenciaAdapter(minhasPendencias())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_pendencia)

        bt_enviar.setOnClickListener {
            val nv_nome= et_nome.text.toString()
            val nv_pendencia= et_pendencia.text.toString()

            val i = Intent(this, MainActivity::class.java)
            i.putExtra("nv_nome", nv_nome)
            i.putExtra("nv_pendencia",nv_pendencia)
            startActivity(i)
        }

        bt_cancelar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}
