package com.ddona.demorecycleview

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.demorecycleview.databinding.ItemImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private var itemDatas: MutableList<ItemData>
    private var inter: ItemInterface?=null
    constructor(itemDatas: MutableList<ItemData>) {
        this.itemDatas = itemDatas
    }

    fun setInterface(inter:ItemInterface){
        this.inter = inter
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):
            ImageViewHolder {
//        Log.d("ImageAdapter", "onCreateViewHolder.....")
//        //phai co itemview
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(
//                R.layout.item_image,
//                parent, false
//            )
//        return ImageViewHolder(itemView)
        return return ImageViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemDatas.size
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {
        Log.d("ImageAdapter", "onBindViewHolder.....")
        //do du lieu len itemview
        val data:ItemData = itemDatas[position]
//        holder.binding.tvTitle.setText(data.title)
//        holder.binding.tvDescription.setText(data.description)
        holder.binding.ahihi = data
        Glide.with(holder.itemView)
            .load(data.linkImage)
            .into(holder.binding.ivImg)

//        if (data.isSelect){
//            holder.itemView.setBackgroundColor(Color.RED)
//        }else {
//            holder.itemView.setBackgroundColor(Color.WHITE)
//        }

        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                println("click...........")
//               inter?.clickItem(position)
//               inter?.clickItem(holder.adapterPosition)
                data.ahihiDoNgoc = true
                if (data.ahihiDoNgoc){
                    view.setBackgroundColor(Color.RED)
                }else {
                    view.setBackgroundColor(Color.WHITE)
                }


            }
        })
    }

    class ImageViewHolder(val binding: ItemImageBinding) :RecyclerView.ViewHolder(binding.root)

//    class ImageViewHolder(
//        itemView: View
//    ) :RecyclerView.ViewHolder(itemView) {
//        val ivImageView: ImageView
//        val tvTitle: TextView
//        val tvDescription: TextView
//
//        init {
//            ivImageView = itemView.findViewById(R.id.iv_img)
//            tvTitle = itemView.findViewById(R.id.tv_title)
//            tvDescription = itemView.findViewById(R.id.tv_description)
//        }
//
//    }
}