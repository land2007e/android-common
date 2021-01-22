package com.ddona.demorecycleview.ui.model

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ddona.demorecycleview.serviceutil.RetrofitUtils
import com.ddona.demorecycleview.serviceutil.SongAPI
import com.t3h.server.model.database.UserProfile
import com.t3h.server.model.request.RequestLogin
import com.t3h.server.model.response.CommonResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModel : ViewModel{
    private val songAPI:SongAPI
    val loginResponse:MutableLiveData<UserProfile>
    val loginError:MutableLiveData<String>
    val isLoading= ObservableBoolean(false)
    constructor() {
        songAPI = RetrofitUtils.createRetrofit()
        loginResponse = MutableLiveData()
        loginError = MutableLiveData()
        isLoading.set(false)
    }
    fun login(request:RequestLogin){
        isLoading.set(true)
        songAPI.login(request)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    if (it.code==0){
                        loginResponse.value=it.data
                    }else {
                        loginError.value=it.message
                    }
                    isLoading.set(false)
                },
                {
                    loginError.value=it.message
                    isLoading.set(false)
                }
            )
    }
}