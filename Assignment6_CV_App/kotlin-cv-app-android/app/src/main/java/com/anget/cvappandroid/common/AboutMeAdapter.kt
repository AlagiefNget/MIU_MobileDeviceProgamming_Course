package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.net.dtos.TechnicalSkills

class AboutMeAdapter(private val list: List<TechnicalSkills>): RecyclerView.Adapter<AboutMeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutMeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AboutMeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AboutMeViewHolder, position: Int) {
        val technical = list[position]
        holder.bind(technical)
    }

    override fun getItemCount(): Int = list.size
}