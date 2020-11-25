package com.ddona.demorecycleview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.ui.fragment.FaceFragment
import com.ddona.demorecycleview.ui.fragment.LoginFragment
import com.ddona.demorecycleview.ui.fragment.NewFragment
import com.ddona.demorecycleview.ui.fragment.RegisterFragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        addNewFragment()
    }

    private fun addNewFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = NewFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }
    private fun addItemFace() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = FaceFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }
    private fun addLoginFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = LoginFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }

    fun addRegisterFragment(username: String, password: String) {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = RegisterFragment()
        fr.setUserName(username)
        fr.setPassword(password)
//        val b = Bundle()
//        b.putString("username", username)
//        b.putString("password", password)
//
//        fr.arguments = b

        tran
            .setCustomAnimations(
                R.anim.open_open,
                R.anim.open_close,
                R.anim.close_open,
                R.anim.close_close
            )
            .replace(R.id.content, fr)
            .addToBackStack(null)
            .commit()

    }
}