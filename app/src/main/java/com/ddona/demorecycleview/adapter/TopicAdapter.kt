package com.ddona.demorecycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.model.ItemTopic
import kotlinx.android.synthetic.main.item_image.view.*

class TopicAdapter : RecyclerView.Adapter<TopicAdapter.TopicHolder>{
    private val topics:MutableList<ItemTopic>
    private var inter: ITopic?=null
    constructor(topics:MutableList<ItemTopic>){
        this.topics = topics
    }

    fun setInter(inter:ITopic){
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {
        return TopicHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_topic, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        val data = topics[position]
        holder.ivImage.setImageResource(data.imageId)
        holder.tvName.setText(data.name)
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                inter?.clickItem(position)
            }
        })
    }

    interface ITopic{
        fun clickItem(position: Int)
    }

    class TopicHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val ivImage:ImageView
        val tvName:TextView
        init {
            ivImage = itemView.findViewById(R.id.iv_img)
            tvName = itemView.findViewById(R.id.tv_title)
        }
    }
}