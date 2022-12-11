package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.net.dtos.EducationTraining

class EducationAdapter(private val list: List<EducationTraining>): RecyclerView.Adapter<EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EducationViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val education: EducationTraining = list[position]
        holder.bind(education)
    }

    override fun getItemCount(): Int = list.size
}