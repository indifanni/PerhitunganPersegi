package com.example.perhitunganpersegi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersegiAdapter (private val dataSet: MutableList<PersegiData>):
        RecyclerView.Adapter<PersegiAdapter.PersegiHolder>() {
            class PersegiHolder(view: View) : RecyclerView.ViewHolder(view){
                val hsl = view.findViewById<TextView>(R.id.hsl)
                val hapus = view.findViewById<ImageView>(R.id.hapus)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersegiHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.persegi_adapter,parent,false
        )
        return PersegiHolder(view)
    }

    override fun onBindViewHolder(holder: PersegiHolder, position: Int) {
        holder.hsl.text = dataSet[position].hasil
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}