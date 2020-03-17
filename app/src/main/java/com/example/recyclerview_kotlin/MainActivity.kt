  package com.example.recyclerview_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.example.recyclerview_kotlin.model.minhasPendencias
import kotlinx.android.synthetic.main.activity_main.*

  class MainActivity : AppCompatActivity() {

      private val pendenciaAdapter by lazy {
          PendenciaAdapter()
      }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_main.adapter = pendenciaAdapter

        pendenciaAdapter.update(minhasPendencias())

    }
}
