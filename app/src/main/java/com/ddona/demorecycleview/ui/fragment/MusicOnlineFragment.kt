package com.ddona.demorecycleview.ui.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ddona.demorecycleview.MyApp
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.databinding.FragmentMusicOnlineBinding
import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.service.MusicOnlineService
import com.ddona.demorecycleview.ui.adapter.MusicOnlineAdapter

class MusicOnlineFragment : Fragment(), MusicOnlineAdapter.IMusicOnline, View.OnClickListener {
    private lateinit var binding: FragmentMusicOnlineBinding
    private var service:MusicOnlineService?=null
    private var conn :ServiceConnection?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicOnlineBinding.inflate(
            inflater,
            container,
            false
        )
        binding.rc.layoutManager = GridLayoutManager(context, 2)
        binding.rc.adapter = MusicOnlineAdapter(this)

        binding.data = (context!!.applicationContext as MyApp).songModelOnline

        openServiceUnBound()

        createConnectService()


        binding.btnSearch.setOnClickListener(this)
        register()
        return binding.root
    }

    private fun register(){
        //dang ky su thay doi gia tri cua musicOnlines: observe
        (context!!.applicationContext as MyApp)
            .songModelOnline.musicOnlines.observe(this, Observer {
//                it: gia tri thay doi
                binding.rc.adapter!!.notifyDataSetChanged()
            })
    }

    private fun createConnectService(){
        //tao cau
        conn= object : ServiceConnection{
            override fun onServiceDisconnected(name: ComponentName?) {

            }

            override fun onServiceConnected(name: ComponentName?, binder: IBinder) {
                val myBinder = binder as MusicOnlineService.MyBinder
                service = myBinder.service
                if ( service!!.getMusicOnlines().size == 0){
//                    service?.searchMusicAsyn("")
                    (context!!.applicationContext as MyApp)
                        .songModelOnline.searchSong(null)
                }else {
                    binding.rc.adapter!!.notifyDataSetChanged()
                }

            }
        }
        //tao intent de xac dinh can ket noi den service nao
        val intent = Intent()
        intent.setClass(context!!, MusicOnlineService::class.java)
        //gui yeu cau
        context!!.bindService(intent, conn!!, Context.BIND_AUTO_CREATE)
    }

    private fun openServiceUnBound(){
        val intent = Intent()
        intent.setClass(context!!, MusicOnlineService::class.java)
        //bat service unbound
        //moi lan goi startService thi chac chan vao onStartCommand
        context!!.startService(intent)
    }

    override fun onDestroyView() {
        context!!.unbindService(conn!!)
        super.onDestroyView()
    }

    override fun onItemClick(position: Int) {
        service?.play(position)

    }

    override fun getCount(): Int {
        if ( service == null){
            return 0
        }
       return service!!.getMusicOnlines().size
    }

    override fun getData(position: Int): MusicOnline {
        return service!!.getMusicOnlines()[position]
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_search->{
//                service?.searchMusicAsyn(binding.edtSongName.text.toString())
                (context!!.applicationContext as MyApp)
                .songModelOnline.searchSong(
                        binding.edtSongName.text.toString()
                    )
            }
        }
    }


}