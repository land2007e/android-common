package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.demorecycleview.databinding.ActivityLoginBinding
import com.ddona.demorecycleview.ui.FragmentActivity

class LoginFragment : Fragment(), View.OnClickListener {
    companion object{
        val TAG = LoginFragment::class.java.name
    }

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate..............")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= ActivityLoginBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView....")
        binding.btnLogin.setOnClickListener(this)
        return binding.root
    }
    override fun onClick(v: View) {
        (activity as FragmentActivity).addRegisterFragment(
            binding.edtUsername.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume....")
    }

    override fun onPause() {
        Log.d(TAG, "onPause....")
        super.onPause()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView....")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroyView....")
        super.onDestroy()
    }


}