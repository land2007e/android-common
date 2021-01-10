package com.ddona.demorecycleview.db

import androidx.room.Dao
import androidx.room.Query
import com.ddona.demorecycleview.model.MusicOnline

@Dao
interface SongOnlineDao {
    @Query("SELECT * FROM MusicOnline")
    fun getAllMusicOnline():MutableList<MusicOnline>
}