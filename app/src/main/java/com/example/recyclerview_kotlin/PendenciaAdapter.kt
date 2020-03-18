package com.example.recyclerview_kotlin

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.support.annotation.ColorInt
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview_kotlin.model.Pendencia
import kotlinx.android.synthetic.main.pendencia_item.view.*

class PendenciaAdapter(var pendencias: MutableList<Pendencia>) : RecyclerView.Adapter<PendenciaAdapter.PendenciaViewHolder>() {

    inner class PendenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //função para vincular as pendencias na viewHolder
        //Colocando a letra P dentro do txt_icon
        //adicionando backgroud nos txt_icon de forma aleatória com base na hash
        //adicionar as pendencias nos seus campos designados
        fun bind(pend: Pendencia) {
            with(pend) {
                val hash = nome.hashCode()
                itemView.txt_icon.text = "P" //P de pendência
                itemView.txt_icon.background = itemView.oval(Color.rgb(hash, hash / 2, 0))
                itemView.pendencia_nome.text = nome
                itemView.pendencia_info.text = pendencia
            }
        }
    }

    //inflando a view pendencia_item
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): PendenciaViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.pendencia_item, viewGroup, false
        )
        return PendenciaViewHolder(view)
    }

    //pegando o tamanho das pendencias
    override fun getItemCount(): Int {
        return pendencias.size
    }

    //passando as pendencias para a viewHolder
    //onde o viewHolder vai segurar as informações da view
    override fun onBindViewHolder(viewHolder: PendenciaViewHolder, position: Int) {
        viewHolder.bind(pendencias[position])
    }
}
//adicionar cores nos icones da frente
//adicionando uma nova função para a View
fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}