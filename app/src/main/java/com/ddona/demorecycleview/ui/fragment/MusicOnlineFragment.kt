package com.ddona.demorecycleview.ui.fragment

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ddona.demorecycleview.databinding.FragmentMusicOnlineBinding
import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.ui.adapter.MusicOnlineAdapter
import org.jsoup.Jsoup
import java.lang.Exception

class MusicOnlineFragment : Fragment(), MusicOnlineAdapter.IMusicOnline {
    private lateinit var binding: FragmentMusicOnlineBinding
    private val musicOnlines = mutableListOf<MusicOnline>()
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
        initThreadMusicOnline()
        return binding.root
    }

    private fun initThreadMusicOnline() {
        val asyn = object : AsyncTask<Void, Void, MutableList<MusicOnline>>() {
            override fun doInBackground(vararg params: Void?): MutableList<MusicOnline> {
                val list = mutableListOf<MusicOnline>()
                for (i in 1..20){
                    list.addAll(getListItemMusic("https://chiasenhac.vn/mp3/vietnam.html?tab=album-2020&page="+i.toString()))
                }
                return list
            }

            override fun onPostExecute(result: MutableList<MusicOnline>) {
                musicOnlines.clear()
                musicOnlines.addAll(result)
                binding.rc.adapter?.notifyDataSetChanged()
            }
        }
        asyn.execute()
    }

    private fun getListItemMusic(link: String): MutableList<MusicOnline> {
        val musics = mutableListOf<MusicOnline>()
        val doc = Jsoup.connect(link).get()
        val els = doc.select("div.content-wrap")
        for (element in els.first().select("section")) {
            print("t")
            //lay tung item
            for (el in element.select("div.col")) {
                try {
                    val item = el.selectFirst("div.card-header")
                    var linkImage = item.attr("style")
                    linkImage = linkImage.substring(
                        linkImage.indexOf("(") + 1,
                        linkImage.indexOf(")")
                    )
                    val name = item.selectFirst("a").attr("title")
                    val linkHtml = "https://chiasenhac.vn/" + item.selectFirst("a").attr("href")
                    val artist = el.selectFirst("div.card-body").selectFirst("p").text()

                    musics.add(
                        MusicOnline(
                            name, artist, linkHtml, linkImage, null
                        )
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        return musics
    }

    override fun onItemClick(position: Int) {

    }

    override fun getCount(): Int {
       return musicOnlines.size
    }

    override fun getData(position: Int): MusicOnline {
        return musicOnlines[position]
    }
}