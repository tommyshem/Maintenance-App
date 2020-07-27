package com.example.maintenanceapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenanceapp.R
import com.example.maintenanceapp.data.PartsEntity


var data  = listOf<PartsEntity>()
//    set(value) {
//        field = value
//        notifyDataSetChanged()
//    }
class PartsAdapter : RecyclerView.Adapter<PartsAdapter.ViewHolder>(){
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PartsAdapter.ViewHolder, position: Int) {
        val item = data[position]
        //holder.textView.text = item.descriptionOfPart.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_parts, parent, false) as TextView
        return PartsAdapter.ViewHolder(view)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //todo: add reference to the list item
    }
}