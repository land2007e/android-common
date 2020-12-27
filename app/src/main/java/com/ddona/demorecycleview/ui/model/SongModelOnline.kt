package com.ddona.demorecycleview.ui.model

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.model.MusicOnline

class SongModelOnline : ViewModel{

    //MutableLiveData: lang nghe su thay doi
    val musicOnlines = MutableLiveData<MutableList<MusicOnline>>()
    val isSearchingData = ObservableBoolean(false)
    constructor(){

    }

}