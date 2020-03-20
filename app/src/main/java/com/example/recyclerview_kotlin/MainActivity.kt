package com.example.recyclerview_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.recyclerview_kotlin.click_listeners.OnEditListener
import com.example.recyclerview_kotlin.model.Pendencia
import com.example.recyclerview_kotlin.model.minhasPendencias
import com.example.recyclerview_kotlin.model.pendencia
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnEditListener {

    //lazy funciona de forma preguiçosa, de forma que só inicializa a property
    //na primeira vez que for utilizada, nas proximas vezes que usar, o valor é atribuido e
    //devolvido imediatamente
    private val pendenciaAdapter by lazy {
        PendenciaAdapter(minhasPendencias(), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //dando um get/set no adapter
        recycler_view_main.adapter = pendenciaAdapter
        //para a construção de listas verticais
        recycler_view_main.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        val nv_pendencia = intent.getStringArrayListExtra("nv_pendencia")

        //ação do botão FAB(FloatingActionButton) quando clicado
        //adiciona essa nova pendencia
        fab.setOnClickListener {
            val i: Intent = Intent(this, NovaPendencia::class.java)
            if (nv_pendencia != null) {
                i.putStringArrayListExtra("pendencias", nv_pendencia)
            }
            startActivity(i)
        }

        //verifica se o arraylist vinda da outra view esta vazia, se estiver, não entra no if
        //se tiver algo, entra e faz o cadastro
        if (nv_pendencia != null) {
            for (i in nv_pendencia.indices step 2) {
                recycler_view_main.run {
                    pendenciaAdapter.pendencias.add(0, pendencia {
                        nome = nv_pendencia[i]
                        pendencia = nv_pendencia[i + 1]
                    })
                    recycler_view_main.scrollToPosition(0)
                }
            }
        }

    }

    //o Adapter chama essa função quando tem um click em cima do item
    override fun editItem(person: Pendencia, index: Int) {

        val intent = Intent(this, EditPendencia::class.java)
        intent.putExtra("person", person.nome)
        intent.putExtra("person1", person.pendencia)
        intent.putExtra("index", index)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //verificando o que veio da outra activity
        if (resultCode == Activity.RESULT_OK && data != null) {
            //pegando os dados da intent vindas pelo bundle
            val intent = data.extras
            //adicionando os itens vindos a variaveis
            val person = intent?.getString("nome")
            val penden = intent?.getString("pende")
            val index = intent?.getInt("i", -1)
            //verificando se veio o index do item que eu quero alterar
            if (index == -1)
                return //caso não venha, ele corta o que esta abaixo
            //verifica se existe algo nas variaveis para nao inserir null nos itens
            if (person != null && penden != null) {
                //caso as variaveis tenham algo executa o codigo de atualização
                //os dois "!!", significa que o index não pode ser null
                pendenciaAdapter.pendencias[index!!] = pendencia {
                    nome = person
                    pendencia = penden
                }
                pendenciaAdapter.notifyItemChanged(index)
            }

        }

    }
}


