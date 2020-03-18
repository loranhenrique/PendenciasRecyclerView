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
        viewHolder.bind(pendencias[position])
    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}