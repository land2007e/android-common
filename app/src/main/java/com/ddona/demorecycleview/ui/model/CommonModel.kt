package com.ddona.demorecycleview.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.model.MessageContent

class CommonModel :ViewModel{
    companion object{
        private var model:CommonModel? = null

        fun getModel():CommonModel{
            if (model == null){
                model = CommonModel()
            }
            return model!!
        }
    }
    val contentMessage= MutableLiveData<MessageContent>()
    private constructor(){

    }
}