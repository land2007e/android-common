package com.ddona.demorecycleview.ui.model

import android.content.Context
import android.os.Environment
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.MyApp
import com.ddona.demorecycleview.model.MusicOnline
import com.ddona.demorecycleview.model.MusicOnlineMp3
import com.ddona.demorecycleview.serviceutil.RetrofitUtils
import com.ddona.demorecycleview.serviceutil.SongAPI
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.FileOutputStream
import java.net.URL

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
                    val key = if (songName != null) songName!!.trim() else ""
                    for (musicOnline in it) {
                        musicOnline.keySearch = key
                    }

                    //xoa
                    MyApp.getDB().musicOnlineDao()
                        .deleteByKey(key)
                    //insert
                    MyApp.getDB().musicOnlineDao()
                        .insertAll(it)

                    musicOnlines.value = it
                    isSearchingData.set(false)


                },
                //that bai
                {
                    val key = if (songName != null) songName!!.trim() else ""

                    isSearchingData.set(false)
                    musicOnlines.value =
                        MyApp.getDB().musicOnlineDao()
                            .selectByKey(key)
                }
            )
    }

    fun saveInToDatabase(item: MusicOnline, context: Context) {
        if (MyApp.getDB().musicOnlineMp3Dao().findOneById(
                item.id
            ) != null
        ) {
            return
        }
        val path =
            Environment.getDataDirectory().path +
                    "/data/" + context.packageName + "/" +
                    item.songName + ".mp3"

        val input = URL(item.linkMusic).openStream()
        val out = FileOutputStream(path)
        val b = ByteArray(1024)
        var le = input.read(b)
        while (le >=0){
            out.write(b, 0, le)
            le = input.read(b)
        }
        out.close()
        input.close()

        val mp3 = MusicOnlineMp3(
            item.id,
            item.songName, item.linkMusic!!, item.linkSong, path
        )
        MyApp.getDB().musicOnlineMp3Dao().insertOne(mp3)
    }

}