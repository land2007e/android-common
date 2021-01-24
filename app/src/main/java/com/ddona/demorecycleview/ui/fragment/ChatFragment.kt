package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.databinding.FragmentChatBinding
import com.ddona.demorecycleview.model.MessageContent
import com.ddona.demorecycleview.ui.adapter.ChatAdapter
import com.ddona.demorecycleview.ui.model.CommonModel
import com.example.demosocket.SocketManager

class ChatFragment : Fragment, View.OnClickListener, ChatAdapter.IChat {
    private val senderId: Int
    private val friendId: Int
    private lateinit var binding: FragmentChatBinding
    private val messages = mutableListOf<MessageContent>()
    constructor(senderId: Int, friendId: Int) {
        this.senderId = senderId
        this.friendId = friendId
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        inits()
        return binding.root
    }

    private fun inits() {
        binding.rc.layoutManager = LinearLayoutManager(context)
        (binding.rc.layoutManager as LinearLayoutManager).stackFromEnd=true
        binding.rc.adapter = ChatAdapter(this, friendId)
        SocketManager.getInstance().connect(senderId)
        binding.btnSend.setOnClickListener(this)
        CommonModel.getModel().contentMessage.observe(this, Observer {
            if ( it.senderId == friendId){
                messages.add(it)
                binding.edtMessage.setText("")
                binding.rc.adapter!!.notifyItemInserted(
                    messages.size-1
                )
                binding.rc.scrollToPosition(
                    messages.size-1
                )
            }
        })
    }

    override fun onClick(v: View) {
        val message = SocketManager.getInstance().sendMessage(
            senderId, friendId,
            binding.edtMessage.text.toString()
        )
        messages.add(message)
        binding.edtMessage.setText("")
        binding.rc.adapter!!.notifyItemInserted(
            messages.size-1
        )
        binding.rc.scrollToPosition(
            messages.size-1
        )
    }

    override fun onDestroy() {
        SocketManager.getInstance().disconnect()
        super.onDestroy()
    }

    override fun getData(position: Int): MessageContent {
        return messages[position]
    }

    override fun getCount(): Int {
        return messages.size
    }
}