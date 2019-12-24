package com.ismin.opendataapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter( //creates new items in the form of ViewHolders, populates the ViewHolders with data, and returns information about the data
    private var womenList: ArrayList<Women>,
    private val context: Context?,
    var clickListener: OnWomanClickListener
) : RecyclerView.Adapter<ListViewHolder>() {

    // Gets the number of femmes in the list
    override fun getItemCount(): Int {
        return womenList.size
    }

    // Inflates the item views
    // inflate the fragment_one view that we will be using to hold each list item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_women,
                parent,
                false
            )
        )
    }

    // We will bind the list items to TextViews
    override fun onBindViewHolder(viewholder: ListViewHolder, position: Int) {
//        val id = this.womenList[position].fields.name
//        viewholder.itemID.text = id

        viewholder.initializeBinding(womenList.get(position), clickListener)
    }

}