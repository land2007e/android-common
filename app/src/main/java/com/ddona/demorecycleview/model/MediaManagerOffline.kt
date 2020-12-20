package com.ddona.demorecycleview.model

import android.media.MediaPlayer
import android.util.Log

class MediaManagerOffline {
    private var mp: MediaPlayer? = null

    constructor() {

    }

    fun setData(path: String) {
        mp?.release()
        mp = MediaPlayer()
        mp?.setOnErrorListener(object : MediaPlayer.OnErrorListener {
            override fun onError(mp2: MediaPlayer?, what: Int, extra: Int): Boolean {
                mp = null
                Log.d("MediaManagerOffline", "error: " + extra)
                return true
            }
        })
        mp?.setDataSource(path)
        mp?.prepare()
    }



    fun play() {
        mp?.start()
    }

    fun pause() {
        mp?.pause()
    }

    fun stop() {
        mp?.stop()
    }

    fun release(){
        mp?.release()
    }

}