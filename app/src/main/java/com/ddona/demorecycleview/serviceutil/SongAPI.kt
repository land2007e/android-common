package com.ddona.demorecycleview.serviceutil

import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.ui.model.SongModelOnline
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import retrofit2.http.Query

open interface SongAPI{
    @GET("/api/searchSong")
    fun songSearch(
        @Query("songName") songName:String?,
        @Query("currentPage") currentPage:Int=1
    ):Observable<MutableList<MusicOnline>>


}