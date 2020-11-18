package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.demorecycleview.databinding.ActivityRegisterBinding

class RegisterFragment : Fragment(){
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityRegisterBinding.inflate(
            inflater, container, false
        )
        binding.edtUsername.setText(
            arguments?.getString("username")
        )
        return binding.root
    }
}