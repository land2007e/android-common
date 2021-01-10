package com.ddona.demorecycleview.ui.model

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.serviceutil.RetrofitUtils
import com.ddona.demorecycleview.serviceutil.SongAPI
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SongModelOnline : ViewModel {
    private val songAPI: SongAPI

    //MutableLiveData: lang nghe su thay doi
    val musicOnlines = MutableLiveData<MutableList<MusicOnline>>()
    val isSearchingData = ObservableBoolean(false)

    constructor() {
        songAPI = RetrofitUtils.createRetrofit()
    }

    fun searchSong(songName: String?, page: Int = 1) {
        isSearchingData.set(true)
        songAPI.songSearch(songName, page)
            //chuyen sang thread khac de tuong tac voi internet
            .subscribeOn(Schedulers.newThread())
            //khi co ket qua tra ve, thi chuyen sang main thread
            //de cap nhap giao dien
            .observeOn(AndroidSchedulers.mainThread())
            //hung ket qua tra ve tu internet
            .subscribe(
                //thanh cong
                {
                    musicOnlines.value=it
                    isSearchingData.set(false)
                },
                //that bai
                {
                    isSearchingData.set(false)
                }
            )
    }

}