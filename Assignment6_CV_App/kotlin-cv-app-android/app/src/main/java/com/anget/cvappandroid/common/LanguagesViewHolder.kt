package com.anget.cvappandroid.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anget.cvappandroid.R
import com.anget.cvappandroid.net.dtos.Item
import com.anget.cvappandroid.net.dtos.Language

class LanguagesViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_languages, parent, false)),
SeekBar.OnSeekBarChangeListener {
    private var txv_language_name: TextView? = null
    private var txv_item: TextView? = null
    private var seek_bar: SeekBar? = null

    init {
        txv_language_name = itemView.findViewById(R.id.txv_language_name)
        txv_item = itemView.findViewById(R.id.txv_item)
        seek_bar = itemView.findViewById(R.id.seek_bar)
    }

    @SuppressLint("ClickableViewAccessibility")
    fun bind(language: Language) {
        txv_language_name?.text = language.language

        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        seek_bar?.layoutParams = layoutParams
        seek_bar?.setOnSeekBarChangeListener(this)
        seek_bar?.progress = language.level!!

        seek_bar?.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        txv_item?.text = when(p1) {
            0 -> Item.None.name
            1 -> Item.Basic.name
            2 -> Item.Elementary.name
            3 -> Item.Fluent.name
            else -> Item.Native.name
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {  }

    override fun onStopTrackingTouch(p0: SeekBar?) {  }
}