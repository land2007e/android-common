package com.ddona.demorecycleview

import android.app.Application
import com.ddona.demorecycleview.db.DataBaseManager

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        DataBaseManager(this).createHighScore()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}