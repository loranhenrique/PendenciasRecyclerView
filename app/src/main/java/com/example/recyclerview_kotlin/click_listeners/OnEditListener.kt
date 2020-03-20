package com.example.recyclerview_kotlin.click_listeners

import com.example.recyclerview_kotlin.model.Pendencia

interface OnEditListener {
    fun editItem(person: Pendencia, index: Int)
}
