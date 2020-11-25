package com.ddona.demorecycleview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddona.demorecycleview.databinding.ItemNewBinding
import com.ddona.demorecycleview.model.ItemNew

class NewAdapter : RecyclerView.Adapter<NewAdapter.NewHolder> {
    private val inter: INewAdapter

    constructor(inter: INewAdapter) {
        this.inter = inter
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewHolder {
        return NewHolder(
            ItemNewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = inter.getCount()

    override fun onBindViewHolder(
        holder: NewHolder,
        position: Int
    ) {
        holder.binding.data = inter.getData(position)
    }

    interface INewAdapter {
        fun getCount(): Int
        fun getData(position: Int): ItemNew
    }

    class NewHolder(val binding: ItemNewBinding) : RecyclerView.ViewHolder(binding.root)
}