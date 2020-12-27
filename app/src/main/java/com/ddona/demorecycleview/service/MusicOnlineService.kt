package com.ddona.demorecycleview.service

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.Binder
import android.os.IBinder
import com.ddona.demorecycleview.MyApp
import com.ddona.demorecycleview.model.MediaManagerOnline
import com.ddona.demorecycleview.model.MusicOnline
import org.jsoup.Jsoup
import java.lang.Exception
import java.util.concurrent.Executors

class MusicOnlineService : Service() {
    private val musicOnlines = mutableListOf<MusicOnline>()
    private val media = MediaManagerOnline()

    fun getMusicOnlines() = musicOnlines

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        return MyBinder(this)
    }

    class MyBinder : Binder {
        val service: MusicOnlineService

        constructor(service: MusicOnlineService) {
            this.service = service
        }
    }


    fun initThreadMusicOnline() {
        val asyn = object : AsyncTask<Void, Void, MutableList<MusicOnline>>() {
            override fun doInBackground(vararg params: Void?): MutableList<MusicOnline> {
                val list = mutableListOf<MusicOnline>()
                for (i in 1..20) {
                    list.addAll(getListItemMusic("https://chiasenhac.vn/mp3/vietnam.html?tab=album-2020&page=" + i.toString()))
                }
                return list
            }

            override fun onPostExecute(result: MutableList<MusicOnline>) {
                musicOnlines.clear()
                musicOnlines.addAll(result)
            }
        }
        asyn.execute()
    }

    fun searchMusic(songName: String, page: Int = 1): MutableList<MusicOnline> {
        var newName = songName
        while (newName.contains("  ")) {
            newName = newName.replace("  ", " ")
        }
        newName = newName.trim()
        val link = "https://chiasenhac.vn/tim-kiem?q={0}&page_music={1}&filter="
            .replace("{0}", newName)
            .replace("{1}", page.toString())
            .replace(" ", "%20")
        val listMusic = mutableListOf<MusicOnline>()
        val doc = Jsoup.connect(link).get()
        for (element in doc.selectFirst("div.tab-content").select("li.media")) {
            try {
                val linkHtml = element.selectFirst("div.media-left").selectFirst("a").attr("href")
                val title = element.selectFirst("div.media-left").selectFirst("a").attr("title")
                val linkImage =
                    element.selectFirst("div.media-left").selectFirst("a").selectFirst("img")
                        .attr("src")
                val artist = element.selectFirst("div.author").text()
                listMusic.add(
                    MusicOnline(
                        title, artist, linkHtml, linkImage
                    )
                )
            } catch (e: Exception) {

            }
        }

        return listMusic

    }

    fun searchMusicAsyn(name: String) {
        (applicationContext as MyApp).songModelOnline.isSearchingData.set(true)
        val asyn = object : AsyncTask<Void, Void, MutableList<MusicOnline>>() {
            override fun doInBackground(vararg params: Void?): MutableList<MusicOnline> {
                val listMusic = mutableListOf<MusicOnline>()
                listMusic.addAll(searchMusic(name, 1))
                listMusic.addAll(searchMusic(name, 2))
                listMusic.addAll(searchMusic(name, 3))
                listMusic.addAll(searchMusic(name, 4))
                return listMusic
            }

            override fun onPostExecute(result: MutableList<MusicOnline>) {
                musicOnlines.clear()
                musicOnlines.addAll(result)

                (applicationContext as MyApp)
                    .songModelOnline.musicOnlines.value = result
                (applicationContext as MyApp).songModelOnline.isSearchingData.set(false)

            }
        }
        asyn.executeOnExecutor(Executors.newFixedThreadPool(1))
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
                    val linkHtml = "https://vi.chiasenhac.vn" + item.selectFirst("a").attr("href")
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

    private fun getLinkMusicAsyn(linkHtml: String, position: Int) {
        val asyn = object : AsyncTask<Void, Void, String?>() {
            override fun doInBackground(vararg params: Void?): String? {
                return getLinkMusic(linkHtml = linkHtml)
            }

            override fun onPostExecute(result: String?) {
                musicOnlines[position].linkMusic = result
                if (result != null) {
                    media.setPath(result!!)
                }

            }
        }

        asyn.execute()
    }

    private fun getLinkMusic(linkHtml: String): String? {
        val doc = Jsoup.connect(linkHtml).get()
        val els = doc.select("div.tab-content")
        for (e in els.first().select("ul.list-unstyled")
            .first().select("a.download_item")) {
            val link = e.attr("href")
            if (link.contains(".mp3")) {
                return link
            }
        }

        return null
    }

    fun play(position: Int) {
        if (musicOnlines[position].linkMusic == null) {
            getLinkMusicAsyn(musicOnlines[position].linkHtml, position)
        } else {
            media.setPath(musicOnlines[position].linkMusic!!)
        }
    }
}