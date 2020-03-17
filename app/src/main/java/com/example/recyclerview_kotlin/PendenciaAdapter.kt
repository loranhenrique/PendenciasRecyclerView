package com.example.recyclerview_kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview_kotlin.model.Pendencia
import kotlinx.android.synthetic.main.pendencia_item.view.*

class PendenciaAdapter() : RecyclerView.Adapter<PendenciaAdapter.PendenciaViewHolder>() {

    private var pendencias: List<Pendencia> = listOf()

    fun update(novasPendencias: List<Pendencia>){
        pendencias = novasPendencias
        notifyDataSetChanged()
    }

    inner class  PendenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): PendenciaViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.pendencia_item, viewGroup, false
        )
        return PendenciaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pendencias.size
    }

    override fun onBindViewHolder(viewHolder: PendenciaViewHolder, position: Int) {
        viewHolder.itemView.pendencia_text.text = pendencias[position].nome
    }
}