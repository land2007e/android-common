package com.ddona.demorecycleview.serviceutil

import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.ui.model.SongModelOnline
import com.t3h.server.model.database.UserProfile
import com.t3h.server.model.request.RequestLogin
import com.t3h.server.model.response.CommonResponse
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

open interface SongAPI{
    @GET("/song/searchSong")
    fun songSearch(
        @Query("songName") songName:String?,
        @Query("currentPage") currentPage:Int=1
    ):Observable<MutableList<MusicOnline>>

    @POST("/auth/login")
    fun login(
        @Body request:RequestLogin
    ):Observable<CommonResponse<UserProfile>>
}