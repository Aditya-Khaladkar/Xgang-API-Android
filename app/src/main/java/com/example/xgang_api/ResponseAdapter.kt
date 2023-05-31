package com.example.xgang_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResponseAdapter(private val list: List<ResponseData>) : RecyclerView.Adapter<ResponseAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.idTextView)
        val name: TextView = itemView.findViewById(R.id.nameTextView)
        val chutyap: TextView = itemView.findViewById(R.id.chutyapTextView)
        val githubLink: TextView = itemView.findViewById(R.id.githubLinkTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.api_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.id.text = "ID: ${item.id}"
        holder.name.text = "Name: ${item.name}"
        holder.chutyap.text = "Chutyap: ${item.chutyap}"
        holder.githubLink.text = "GitHub Link: ${item.githubLink}"
    }
}