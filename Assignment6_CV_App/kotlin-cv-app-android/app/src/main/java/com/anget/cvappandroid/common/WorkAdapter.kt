package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.net.dtos.WorkExperience

class WorkAdapter(private val list: List<WorkExperience>): RecyclerView.Adapter<WorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WorkViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        val career: WorkExperience = list[position]
        holder.bind(career)
    }

    override fun getItemCount(): Int = list.size
}