package com.ddona.demorecycleview.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.model.MusicOnlineMp3

@Database(entities = arrayOf(MusicOnline::class, MusicOnlineMp3::class), version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun musicOnlineDao(): SongOnlineDao
    abstract fun musicOnlineMp3Dao(): MusicOnlineMp3Dao
}