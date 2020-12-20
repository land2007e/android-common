package com.ddona.demorecycleview.model

import android.net.Uri
import java.util.*

data class MusicOffline(
    val name: String,
    val path: String,
    val duration: Long? = null,
    var uriAlbum: Uri? = null,
    val albumId: Long? = null
)