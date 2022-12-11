package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.R
import com.anget.cvappandroid.net.dtos.EducationTraining
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EducationViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_education_training, parent, false)) {
    private var txv_name: TextView? = null
    private var txv_date: TextView? = null
    private var txv_degree: TextView? = null
    private var txv_course: TextView? = null

    init {
        txv_name = itemView.findViewById(R.id.txv_name)
        txv_date = itemView.findViewById(R.id.txv_date)
        txv_degree = itemView.findViewById(R.id.txv_degree)
        txv_course = itemView.findViewById(R.id.txv_course)
    }

    fun bind(education: EducationTraining) {
        val start = LocalDate.parse(education.date?.start, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val end = LocalDate.parse(education.date?.end, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        txv_name?.text = education.name
        txv_date?.text = String.format(
            "%s/%s - %s/%s",
            start.month.value,
            start.year,
            end.month.value,
            end.year
        )
        if (education.degree.isNullOrEmpty()) {
            txv_degree?.visibility = View.GONE
        } else {
            txv_degree?.text = education.degree
        }
        txv_course?.text = education.course
    }
}