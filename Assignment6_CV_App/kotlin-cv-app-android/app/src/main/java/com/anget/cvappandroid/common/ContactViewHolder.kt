package com.anget.cvappandroid.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.R
import com.anget.cvappandroid.net.dtos.Contact
import com.anget.cvappandroid.net.dtos.TechnicalSkills
import com.anget.cvappandroid.net.stringHyphen

class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.social_network_item_row, parent, false)) {
    private var txv_name: TextView? = null
    private var txv_link: TextView? = null

    init {
        txv_name = itemView.findViewById(R.id.tvSocialNetworkName)
        txv_link = itemView.findViewById(R.id.tvSocialNetworkLink)
    }

    fun bind(contact: Contact) {
        txv_name?.text = contact.name
        txv_link?.text = contact.value
    }
}