package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.FragmentFaceBinding
import com.ddona.demorecycleview.ui.fragment.pager.FaceAdapter
import com.ddona.demorecycleview.ui.fragment.pager.ItemFace

class FaceFragment :Fragment(){
    private val itemFaces = mutableListOf<ItemFace>()
    private lateinit var binding:FragmentFaceBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFaceBinding.inflate(
            inflater,
            container,
            false
        )
        itemFaces.add(ItemFace(R.drawable.icon_128_20,"Icon 128"))
        itemFaces.add(ItemFace(R.drawable.boss,"BOSS"))
        itemFaces.add(ItemFace(R.drawable.icon_6,"Icon 6"))
        itemFaces.add(ItemFace(R.drawable.icon_128_38,"Icon 38"))
        itemFaces.add(ItemFace(R.drawable.happy,"happy"))
        binding.vp.adapter = FaceAdapter(itemFaces)
        return binding.root
    }
}