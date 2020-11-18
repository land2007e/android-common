package com.ddona.demorecycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.adapter.StoreAdapter
import com.ddona.demorecycleview.databinding.ActivityStoresListBinding
import com.ddona.demorecycleview.model.ItemTopic

class StoreListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoresListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_stores_list
        )
        val topic = intent.getSerializableExtra("DATA") as ItemTopic
        binding.tvTitle.setText(topic.name)
        val adapter = StoreAdapter(topic.stores)
        binding.rcStore.adapter=adapter
        binding.rcStore.layoutManager = LinearLayoutManager(this)
    }
}