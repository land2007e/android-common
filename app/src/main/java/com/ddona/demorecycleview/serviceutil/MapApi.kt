package com.ddona.demorecycleview.serviceutil

import com.ddona.demorecycleview.model.MapDirection
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MapApi {
    @GET("/maps/api/directions/json")
    fun direction(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("key") key: String="AIzaSyDAKQPUGwE9yQLsr3CrTSdS2NxoE1p9nOs",
        @Query("mode") mode: String = "DRIVING"
    ): Observable<MapDirection>
}