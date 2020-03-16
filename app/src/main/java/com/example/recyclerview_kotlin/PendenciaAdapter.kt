package com.example.recyclerview_kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview_kotlin.model.Pendencia

class PendenciaAdapter(val pendencias: MutableList<Pendencia>) : RecyclerView.Adapter<PendenciaViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PendenciaViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(
            R.layout.pendencia_item, p0, false
        )
        return PendenciaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pendencias.size
    }

    override fun onBindViewHolder(p0: PendenciaViewHolder, p1: Int) {
        TODO("Not yet implemented")
    }
}

class PendenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
