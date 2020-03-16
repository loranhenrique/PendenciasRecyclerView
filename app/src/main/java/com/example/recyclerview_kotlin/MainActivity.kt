  package com.example.recyclerview_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView

  class MainActivity : AppCompatActivity() {

      lateinit var pendenciaAdapter: PendenciaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pendenciaAdapter = PendenciaAdapter()

        val rv: RecyclerView = findViewById(R.id.recycler_view_main)

        rv.adapter

    }
}
