package com.ddona.demorecycleview.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.lifecycle.LifecycleService
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.ddona.demorecycleview.MyApp
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.model.MediaManagerOnline
import com.ddona.demorecycleview.model.MusicOnline
import org.jsoup.Jsoup
import java.util.concurrent.Executors


class MusicOnlineService :LifecycleService()  {
    private val musicOnlines = mutableListOf<MusicOnline>()
    private val media = MediaManagerOnline()
    private var currentPosition = -1

    fun getMusicOnlines() = musicOnlines

    override fun onCreate() {
        super.onCreate()
        (applicationContext as MyApp).songModelOnline
            .musicOnlines.observe(this, Observer{
                musicOnlines.clear()
                musicOnlines.addAll(it)
            })
    }



    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        return MyBinder(this)
    }

    //unbound
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        //force thi service chet
        if (intent != null) {
            action(intent)
        }
        return START_NOT_STICKY
        //chet di song lai
//        return START_STICKY
        //chet di song lai 1 lan
//        return START_REDELIVER_INTENT
//        return START_NOT_STICKY
    }

    private fun action(intent: Intent) {
        if (intent.action == null) {
            return
        }
        when (intent.action) {
            "PREVIOUS" -> {
                if (currentPosition == 0) {
                    return
                }
                play(currentPosition - 1)
            }
            "PLAY" -> {
                pause(currentPosition)
            }
            "PAUSE" -> {
                play(currentPosition)
            }
            "NEXT" -> {
                if (currentPosition == musicOnlines.size - 1) {
                    return
                }
                play(currentPosition + 1)
            }
        }
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
                var linkHtml = element.selectFirst("div.media-left").selectFirst("a").attr("href")
                if (!linkHtml.startsWith("http")) {
                    linkHtml = "https://vi.chiasenhac.vn" + linkHtml
                }
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
        currentPosition = position
        createNotification(position)
        if (musicOnlines[position].linkMusic == null) {
            getLinkMusicAsyn(musicOnlines[position].linkSong, position)
        } else {
            media.setPath(musicOnlines[position].linkMusic!!)
        }
    }

    fun pause(position: Int) {
        currentPosition = position
        media.pause()
        createNotification(position, isPlaying = true)
    }

    private fun createNotification(
        position: Int, isPlaying: Boolean = false
    ) {
        createChannel()
//        val no = NotificationCompat.Builder(this,"NO")
//            .setContentTitle("Music")
//            .setContentText(musicOnlines[position].name + "\n"+musicOnlines[position].artist)
//            .setSmallIcon(R.drawable.baseline_home_purple_500_48dp)
//            .setLargeIcon(BitmapFactory.decodeResource(
//                resources, R.drawable.aodai2
//            ))
//            .build()
//        startForeground(1, no)
        val remoteView = RemoteViews(packageName, R.layout.layout_notification_music)
        remoteView.setTextViewText(R.id.tv_name, musicOnlines[position].songName)
        remoteView.setTextViewText(R.id.tv_artist, musicOnlines[position].artistName)
        remoteView.setImageViewBitmap(
            R.id.btn_play,
            BitmapFactory.decodeResource(
                resources,
                if (isPlaying) R.drawable.baseline_pause_purple_500_48dp else
                    R.drawable.baseline_play_arrow_purple_500_48dp
            )
        )
        createPendingIntentMusic(remoteView, isPlaying)
        val no = NotificationCompat.Builder(this, "NO")
            .setSmallIcon(R.drawable.baseline_music_note_black_24dp)
            .setContent(remoteView)
            .setCustomBigContentView(remoteView)
            .build()

        if (musicOnlines[position].linkImage != null) {
            Glide.with(this).asBitmap().load(
                musicOnlines[position].linkImage
            ).into(
                object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        remoteView.setImageViewBitmap(R.id.iv_img, resource)
                        startForeground(1, no)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }
                }
            )

        }

        startForeground(1, no)

    }

    private fun createPendingIntentMusic(remoteViews: RemoteViews, isPlaying: Boolean) {
        val intentPrevious = Intent()
        intentPrevious.setClass(this, MusicOnlineService::class.java)
        intentPrevious.setAction("PREVIOUS")
        val pendingIntentPrevious = PendingIntent.getService(
            this, 1,
            intentPrevious, PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.btn_previous, pendingIntentPrevious)

        val intentPlay = Intent()
        intentPlay.setClass(this, MusicOnlineService::class.java)
        if (isPlaying) {
            intentPlay.setAction("PAUSE")
        } else {
            intentPlay.setAction("PLAY")
        }
        val pendingIntentPlay = PendingIntent.getService(
            this, 2,
            intentPlay, PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.btn_play, pendingIntentPlay)


        val intentNext = Intent()
        intentNext.setClass(this, MusicOnlineService::class.java)
        intentNext.setAction("NEXT")
        val pendingIntentNext = PendingIntent.getService(
            this, 3,
            intentNext, PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.btn_next, pendingIntentNext)


    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("NO", "NO", importance)
            channel.description = "NO"
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}