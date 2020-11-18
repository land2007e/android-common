package com.ddona.demorecycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.model.Store

class StoreAdapter : RecyclerView.Adapter<StoreAdapter.StoreHolder>{
    private val stores: MutableList<Store>
    constructor(stores: MutableList<Store>){
        this.stores = stores
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        return StoreHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        val data = stores[position]
        holder.tvContent.setText(data.content)
        holder.tvTitle.setText(data.title)
        Glide.with(holder.itemView.context)
            .load(data.linkImage)
            .into(holder.ivImg)
    }

    class StoreHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
         val ivImg:ImageView
         val tvTitle:TextView
         val tvContent:TextView
        init {
            ivImg = itemView.findViewById(R.id.iv_img)
            tvTitle = itemView.findViewById(R.id.tv_title)
            tvContent = itemView.findViewById(R.id.tv_description)
        }
    }
}