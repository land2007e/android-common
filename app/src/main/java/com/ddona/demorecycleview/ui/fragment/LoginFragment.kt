package com.ddona.demorecycleview.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.ActivityLoginBinding
import com.ddona.demorecycleview.model.ShareUtils
import com.ddona.demorecycleview.ui.FragmentActivity
import com.ddona.demorecycleview.ui.model.LoginModel
import com.t3h.server.model.request.RequestLogin
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginFragment : Fragment(), View.OnClickListener {
    companion object {
        val TAG = LoginFragment::class.java.name
    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var model: LoginModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate..............")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityLoginBinding.inflate(inflater, container, false)
        model = LoginModel()
        binding.data = model

        Log.d(TAG, "onCreateView....")
        binding.btnLogin.setOnClickListener(this)
        binding.tvRegister.setOnClickListener(this)

        binding.edtUsername.setText(
            ShareUtils.getUsername(activity!!)
        )
        binding.edtPassword.setText(
            ShareUtils.getPassword(activity!!)
        )
//        binding.btnLogin.setOnClickListener(this)
        register()
        return binding.root
    }

    private fun register(){
        model.loginResponse.observe(this, Observer {
            (activity as FragmentActivity).addMusicOnlineFragmentSecond()
        })
        model.loginError.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
    }



    override fun onClick(v: View) {
//        //save
//        ShareUtils.saveAccount(
//            activity!!,
//            binding.edtUsername.text.toString(),
//            binding.edtPassword.text.toString()
//        )
//

        when (v.id) {
            R.id.btn_login -> {
                val username = binding.edtUsername.text.toString()
                val password = binding.edtPassword.text.toString()
                val user = RequestLogin()
                user.password = password
                user.username = username
                //cal api
                model.login(user)
            }
            R.id.btn_register -> {
                (activity as FragmentActivity).addRegisterFragment(
                    binding.edtUsername.text.toString(),
                    binding.edtPassword.text.toString()
                )
            }
        }
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