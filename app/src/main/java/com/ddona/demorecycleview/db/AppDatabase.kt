package com.ddona.demorecycleview.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ddona.demorecycleview.model.MusicOnline

@Database(entities = arrayOf(MusicOnline::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun musicOnlineDao(): SongOnlineDao
}