package com.ddona.demorecycleview

import android.app.Application
import androidx.room.Room
import com.ddona.demorecycleview.db.AppDatabase
import com.ddona.demorecycleview.db.DataBaseManager
import com.ddona.demorecycleview.ui.model.SongModelOnline

class MyApp : Application() {
    companion object{
        private lateinit var db: AppDatabase
        fun getDB() = db
    }

    lateinit var songModelOnline: SongModelOnline


    override fun onCreate() {
        super.onCreate()
        songModelOnline = SongModelOnline()

        DataBaseManager(this).createHighScore()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }



    override fun onTerminate() {
        super.onTerminate()
    }
}