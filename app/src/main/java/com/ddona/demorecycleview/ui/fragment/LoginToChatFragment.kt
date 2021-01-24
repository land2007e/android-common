package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.demorecycleview.ui.FragmentActivity
import com.ddona.demorecycleview.databinding.FragmentLoginToChatBinding

class LoginToChatFragment:Fragment(){
    private lateinit var binding:FragmentLoginToChatBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentLoginToChatBinding.inflate(
            inflater, container, false
        )
        inits()
        return binding.root
    }
    private fun inits(){
        binding.btnStart.setOnClickListener({
            val to = binding.tvTo.text.toString().toInt()
            val from = binding.tvFrom.text.toString().toInt()
            (activity as FragmentActivity).addChatFragment(
                to, from
            )
        })
    }
}