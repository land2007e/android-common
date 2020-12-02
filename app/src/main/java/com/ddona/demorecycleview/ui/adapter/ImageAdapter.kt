package com.ddona.demorecycleview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.demorecycleview.databinding.ItemImageSquareBinding
import com.ddona.demorecycleview.model.ItemImageLocal
import java.io.File

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private val inter: IImage

    constructor(inter: IImage) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            ItemImageSquareBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = inter.getCount()
    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        Glide.with(holder.binding.iv)
            .load(File(inter.getData(position).path))
            .into(holder.binding.iv)
    }

    interface IImage {
        fun getCount(): Int
        fun getData(position: Int): ItemImageLocal
    }

    class ImageHolder(val binding: ItemImageSquareBinding) : RecyclerView.ViewHolder(binding.root)
}