package com.t3h.server.model.response

class CommonResponse<T>{
    var data:T?=null
    var message:String="SUCCESS"
    var code=0
    constructor(data:T){
        this.data = data
    }
    constructor(message:String, code:Int){
        this.message = message
        this.code = code
    }
}