package com.example.recyclerview_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_pendencia.*

class EditPendencia : AppCompatActivity() {

    var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pendencia)

        //pegando o index do item da lista que eu quero alterar
        index = intent.getIntExtra("index", -1)

        //pegando o nome da pessoa referente ao item
        var nome = intent.getStringExtra("person")
        //pegando a pedencia referente ao item
        var pendencia = intent.getStringExtra("person1")

        //verificando se não veio null da MainActivity
        if (pendencia != null && nome != null) {
            //setando os campos com os valores do item que quero entrar
            nv_nome.setText(nome)
            nv_pendencia.setText(pendencia)
        }

        //chamando o botao enviar
        setBtEnviar()
        //chamando o botao cancelar
        setBtCancelar()

    }

    //cancelando a alteração
    private fun setBtCancelar() {
        bt_cancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    //botão para enviar a atualização
    private fun setBtEnviar() {
        bt_enviar.setOnClickListener {

            //pegando o que o usuario digitou nos EditText
            val nome = nv_nome.text.toString()
            val pende = nv_pendencia.text.toString()

            //criando a intent
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("i", index)
            i.putExtra("nome", nome)
            i.putExtra("pende", pende)
            i.putExtras(i) //enviando os dados da intent pelo Bundle

            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}
