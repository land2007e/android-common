package com.ddona.demorecycleview

import android.app.Application
import com.ddona.demorecycleview.db.DataBaseManager
import com.ddona.demorecycleview.ui.model.SongModelOnline

class MyApp : Application(){
    lateinit var songModelOnline :SongModelOnline
    override fun onCreate() {
        super.onCreate()
        songModelOnline = SongModelOnline()

        DataBaseManager(this).createHighScore()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}