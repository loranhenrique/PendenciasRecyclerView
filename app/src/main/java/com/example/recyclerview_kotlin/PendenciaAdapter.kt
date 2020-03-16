package com.example.recyclerview_kotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview_kotlin.model.Pendencia

class PendenciaAdapter() : RecyclerView.Adapter<PendenciaViewHolder>() {

    private lateinit var pendencias: MutableList<Pendencia>


    constructor(pendencias: MutableList<Pendencia>) : this() {
        this.pendencias = pendencias
    }




    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PendenciaViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(p0: PendenciaViewHolder, p1: Int) {
        TODO("Not yet implemented")
    }
}

class PendenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
