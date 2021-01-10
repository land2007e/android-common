package com.ddona.demorecycleview.db

import androidx.room.*
import com.ddona.demorecycleview.model.MusicOnline

@Dao
interface SongOnlineDao {
    @Query("SELECT * FROM MusicOnline")
    fun getAllMusicOnline(): MutableList<MusicOnline>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(music: MutableList<MusicOnline>)

    @Query("SELECT * FROM MusicOnline WHERE keySearch = :keySearch")
    fun selectByKey(keySearch: String):MutableList<MusicOnline>

    @Query("DELETE FROM MusicOnline WHERE keySearch = :keySearch")
    fun deleteByKey(keySearch: String)
}