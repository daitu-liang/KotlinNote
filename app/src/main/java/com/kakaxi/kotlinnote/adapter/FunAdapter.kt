package com.kakaxi.kotlinnote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kakaxi.kotlinnote.R

class FunAdapter(val context: Context,val list:List<String>): RecyclerView.Adapter<FunAdapter.ViewHold>() {
    inner class ViewHold(view:View):RecyclerView.ViewHolder(view) {
        val des:TextView=view.findViewById(R.id.tv_des)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val view=LayoutInflater.from(context).inflate(R.layout.item_fun,parent,false)
        return ViewHold(view)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
      holder.des.text=list.get(position)
    }
}