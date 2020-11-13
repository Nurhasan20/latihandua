package com.example.latihandua

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.detail.view.*
import kotlinx.android.synthetic.main.item.view.*

class adapter (val ItemList: List<data>, val clickListener: (data) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(ItemList[position], clickListener)
    }

    override fun getItemCount() = ItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fak: data, clickListener: (data) -> Unit) {
            itemView.namaFakul.text = fak.namaFak.toString()
            itemView.setOnClickListener{clickListener(fak)}
        }
    }
}