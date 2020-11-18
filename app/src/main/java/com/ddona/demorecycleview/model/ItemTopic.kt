package com.ddona.demorecycleview.model

import java.io.Serializable

data class ItemTopic(val imageId:Int,
                     val name:String,
                     val stores:MutableList<Store>) : Serializable