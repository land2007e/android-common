package com.ddona.demorecycleview.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.model.MusicOnline

class SongModelOnline : ViewModel{
    //MutableLiveData: lang nghe su thay doi
    val musicOnlines = MutableLiveData<MutableList<MusicOnline>>()
    constructor(){

    }

}