package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ddona.demorecycleview.databinding.FragmentStoreBinding
import com.ddona.demorecycleview.model.ItemImageLocal
import com.ddona.demorecycleview.ui.adapter.ImageAdapter

class StorageFragment : Fragment(), ImageAdapter.IImage {
    private val images = mutableListOf<ItemImageLocal>()
    private lateinit var binding:FragmentStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(
            inflater, container, false
        )
        loadAllImage()
        binding.tvNumber.setText(getCountImage().toString())
        binding.rc.layoutManager = GridLayoutManager(context,3)
        binding.rc.adapter = ImageAdapter(this)
        return binding.root
    }

    private fun loadAllImage(){
//        uri dia chi cua bang
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = context!!.contentResolver
            .query(uri, null, null, null, null)
        cursor!!.moveToFirst()
        while (!cursor.isAfterLast){
            val path = cursor.getString(
                cursor.getColumnIndex("_data")
            )
            images.add(ItemImageLocal(path))
            cursor.moveToNext()
        }
        cursor.close()
    }

    fun getCountImage():Int{
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = context!!.contentResolver
            .query(uri, arrayOf("COUNT(*) as c"), null, null, null)
        cursor!!.moveToFirst()
        var count = 0
        while (!cursor.isAfterLast){
            count = cursor.getInt(
                cursor.getColumnIndex("c")
            )
            cursor.moveToNext()
        }
        cursor.close()
        return count
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getData(position: Int): ItemImageLocal {
        return images[position]
    }
}