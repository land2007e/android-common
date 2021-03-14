package com.ddona.demorecycleview.ui.map

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.ActivityDirectionMapBinding

class DirectionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDirectionMapBinding
    private lateinit var fragmentMap: MyMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_direction_map
        )

        fragmentMap = MyMapFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.content, fragmentMap)
            .commit()

        binding.btnSearch.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        fragmentMap.searchDirection(
            binding.edtOrigin.text.toString(),
            binding.edtDestination.text.toString()
        )
    }
}