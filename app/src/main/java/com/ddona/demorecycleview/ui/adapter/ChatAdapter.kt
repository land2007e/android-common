package com.ddona.demorecycleview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddona.demorecycleview.databinding.ItemReceiverBinding
import com.ddona.demorecycleview.databinding.ItemSenderBinding
import com.ddona.demorecycleview.model.MessageContent

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private val inter: IChat
    private val friendId: Int

    constructor(inter: IChat, friendId: Int) {
        this.inter = inter
        this.friendId = friendId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            return SenderViewHolder(
                ItemSenderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        }
        return ReceiverViewHolder(
            ItemReceiverBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun getItemCount(): Int {
        return inter.getCount()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SenderViewHolder){
            (holder as SenderViewHolder).binding.data = inter.getData(position)
        }else {
            (holder as ReceiverViewHolder).binding.data = inter.getData(position)

        }
    }

    override fun getItemViewType(position: Int): Int {
        if (inter.getData(position).receiverId == friendId) {
            return 0
        }
        return 1
    }

    interface IChat {
        fun getData(position: Int): MessageContent
        fun getCount(): Int
    }

    class SenderViewHolder(val binding: ItemSenderBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    class ReceiverViewHolder(val binding: ItemReceiverBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}