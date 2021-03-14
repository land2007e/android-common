package com.ddona.demorecycleview.ui.model

import androidx.annotation.MainThread
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.model.MapDirection
import com.ddona.demorecycleview.serviceutil.MapApi
import com.ddona.demorecycleview.serviceutil.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MapDirectionViewModel : ViewModel {
    val mapDirection: MutableLiveData<MapDirection>
    val isLoading:ObservableBoolean
    private val api: MapApi

    constructor() {
        mapDirection = MutableLiveData()
        api = RetrofitUtils.createRetrofitMap()
        isLoading = ObservableBoolean(false)
    }

    fun direction(origin: String, destination: String): Disposable {
        isLoading.set(true)
        val dis = api.direction(origin, destination)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    isLoading.set(false)
                    mapDirection.value = it
                },
                {
                    isLoading.set(false)
                    it.printStackTrace()
                })
//        dis.dispose()
        return dis
    }
}