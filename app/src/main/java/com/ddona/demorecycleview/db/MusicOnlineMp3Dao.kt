package com.ddona.demorecycleview.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ddona.demorecycleview.model.MusicOnlineMp3

@Dao
interface MusicOnlineMp3Dao {
    @Query("SELECT * FROM MusicOnlineMp3 WHERE id = :id ORDER BY songName LIMIT 1")
    fun findOneById(id:String):MusicOnlineMp3?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(item:MusicOnlineMp3)
}