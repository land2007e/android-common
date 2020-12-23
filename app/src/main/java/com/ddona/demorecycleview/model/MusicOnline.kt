package com.ddona.demorecycleview.model

data class MusicOnline(
    val name:String,
    val artist:String,
    val linkHtml:String,
    var linkImage:String?=null,
    var linkMusic:String?=null
)