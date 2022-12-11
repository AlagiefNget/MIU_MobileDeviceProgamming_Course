package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.net.dtos.Language

class LanguagesAdapter(private val list: List<Language>): RecyclerView.Adapter<LanguagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LanguagesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        val language = list[position]
        holder.bind(language)
    }

    override fun getItemCount(): Int = list.size
}