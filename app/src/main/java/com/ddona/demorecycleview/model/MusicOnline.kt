package com.ddona.demorecycleview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MusicOnline(
    val songName:String,
    val artistName:String,
    val linkSong:String,
    var linkImage:String?=null,
    var linkMusic:String?=null,
    @PrimaryKey
    val id:String=""
)