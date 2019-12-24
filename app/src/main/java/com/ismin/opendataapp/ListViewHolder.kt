package com.ismin.opendataapp

import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(rootView: View) :
    RecyclerView.ViewHolder(rootView) { //cache the view objects in order to save memory
    var itemName: TextView

    fun initializeBinding(woman: Women, action: OnWomanClickListener) {
        itemName.text = woman.fields.name

        itemView.setOnClickListener {
            action.onWomanClick(woman, adapterPosition)
        }
    }

    init {
        this.itemName = rootView.findViewById(R.id.textwomen) //need to change
    }
}

interface OnWomanClickListener {
    fun onWomanClick(woman: Women, position: Int)
}