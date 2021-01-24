package com.ddona.demorecycleview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.ui.fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
//        addMusicOnlineFragment()
//        addLoginFragment()
        addLoginToChatFragment()
    }

    private fun addMusicOnlineFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = MusicOnlineFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }
    private fun addLoginToChatFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = LoginToChatFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }

    fun addChatFragment(senderId:Int, receiverId:Int) {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = ChatFragment(senderId, receiverId)
        tran
            .setCustomAnimations(
                R.anim.open_open,
                R.anim.open_close,
                R.anim.close_open,
                R.anim.close_close
            )
            .replace(R.id.content, fr)
            .commit()
    }

    fun addMusicOnlineFragmentSecond() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = MusicOnlineFragment()
        tran
            .setCustomAnimations(
                R.anim.open_open,
                R.anim.open_close,
                R.anim.close_open,
                R.anim.close_close
            )
            .replace(R.id.content, fr)
            .commit()
    }
    private fun addMusicOfflineFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = MusicOfflineFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }

    private fun addQuestionFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = QuestionFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }
    private fun addStorageFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = StorageFragment()
        tran.add(R.id.content, fr)

        tran.commit()
    }
    private fun addHomFragment() {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val fr = HomeFragment()
        tran.add(R.id.content, fr)

        tran.commit()
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

    fun openDetailFragment(link: String) {
        val manager = supportFragmentManager
        val tran = manager.beginTransaction()
        val b = Bundle()
        b.putString("LINK", link)
        val fr = NewDetailFragment()
        fr.arguments = b
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