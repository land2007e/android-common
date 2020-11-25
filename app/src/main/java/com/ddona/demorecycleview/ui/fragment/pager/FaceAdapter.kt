package com.ddona.demorecycleview.ui.fragment.pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.ddona.demorecycleview.databinding.ItemFaceBinding

class FaceAdapter : PagerAdapter{
    val itemFaces:MutableList<ItemFace>
    constructor(itemFaces:MutableList<ItemFace>) : super(){
        this.itemFaces = itemFaces
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount()= itemFaces.size

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val binding = ItemFaceBinding.inflate(
            LayoutInflater.from(container.context),
            container,
            false
        )
        binding.data = itemFaces[position]
        return binding.root
    }
}