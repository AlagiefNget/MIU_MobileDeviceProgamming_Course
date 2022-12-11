package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.R
import com.anget.cvappandroid.net.dtos.Link

class LinksViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_link, parent, false)) {
    private var name: TextView? = null
    private var link_text: TextView? = null

    init {
        name = itemView.findViewById(R.id.txv_name)
        link_text = itemView.findViewById(R.id.txv_link)
    }

    fun bind(link: Link) {
        name?.text = link.name
        link_text?.text = link.link
    }
}
