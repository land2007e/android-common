package com.example.demosocket

import android.util.Log
import com.ddona.demorecycleview.model.MessageContent
import com.ddona.demorecycleview.ui.model.CommonModel
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.socket.client.IO
import io.socket.client.Manager
import io.socket.client.Socket
import io.socket.emitter.Emitter
import io.socket.engineio.client.Transport
import java.util.*

class SocketManager {
    private lateinit var socket: Socket

    companion object {
        private var instances: SocketManager? = null

        @JvmStatic
        fun getInstance(): SocketManager {
            if (instances == null) {
                instances = SocketManager()
            }
            return instances!!
        }
    }

    private constructor() {

    }

    fun connect(senderId: Int) {
        socket = IO.socket("http://192.168.1.169:9000")
        socket.on(Socket.EVENT_CONNECT, {
            Log.d("SocketManager", "EVENT_CONNECT......")
            socket.emit("info", senderId.toString())
        })
        socket.on(Socket.EVENT_CONNECTING, {
            Log.d("SocketManager", "EVENT_CONNECTING......")
        })
        socket.on(Socket.EVENT_CONNECT_TIMEOUT, {
            Log.d("SocketManager", "EVENT_CONNECT_TIMEOUT......")
        })

        socket.on(Socket.EVENT_DISCONNECT, {
            Log.d("SocketManager", "EVENT_DISCONNECT......")
        })
        socket.on(Socket.EVENT_ERROR, {
            Log.d("SocketManager", "EVENT_ERROR......" + it)
        })
        socket.on(Socket.EVENT_CONNECT_ERROR, {
            Log.d("EVENT_CONNECT_ERROR", "EVENT_ERROR......" + it)
        })
        socket.io().on(Manager.EVENT_TRANSPORT, {
            val transport = it[0] as Transport
            transport.on(Transport.EVENT_REQUEST_HEADERS, { args ->
                Log.d(
                    "SocketManager",
                    "Caught EVENT_REQUEST_HEADERS after EVENT_TRANSPORT, adding headers"
                )
                val mHeaders = args[0] as MutableMap<String, List<String>>
                mHeaders["Authorization"] = Arrays.asList("Basic bXl1c2VyOm15cGFzczEyMw==")
            })
        })

        receiveMessage()

        socket.connect()

    }

    fun sendMessage(
        senderId: Int,
        receiverId: Int,
        value: String
    ): MessageContent {
        val content = MessageContent()
        content.receiverId = receiverId
        content.senderId = senderId
        content.value = value
        socket.emit(
            "message",
            Gson().toJson(content)
        )
        return content
    }

    fun receiveMessage() {
        socket.on("message", {
            print("sdfsdf")
            val t = it[0].toString()

            Observable.create<String>({
                it.onNext(t)
            }).observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val ob = Gson().fromJson(it, MessageContent::class.java)
                    CommonModel.getModel().contentMessage.postValue(ob)
                })
        })
    }

    fun disconnect() {
        socket.disconnect()
    }


}