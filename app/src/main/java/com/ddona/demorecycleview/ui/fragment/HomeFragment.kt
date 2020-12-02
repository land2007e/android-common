package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.demorecycleview.databinding.FragmentHomeNewBinding
import com.ddona.demorecycleview.ui.adapter.HomeAdapter

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeNewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeNewBinding.inflate(
            inflater,
            container, false
        )
        binding.tab.setupWithViewPager(
            binding.vp
        )
        binding.vp.adapter = HomeAdapter(childFragmentManager)
        return binding.root
    }
}