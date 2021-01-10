package com.ddona.demorecycleview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MusicOnlineMp3 (
    @PrimaryKey
    var id:String="",
    var songName:String,
    var linkMusic:String,
    var linkHtml:String,
    var pathOnline:String
)