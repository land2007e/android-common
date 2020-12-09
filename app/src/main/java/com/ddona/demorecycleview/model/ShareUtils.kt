package com.ddona.demorecycleview.model

import android.content.Context

object ShareUtils {
    @JvmStatic
    fun saveAccount(
        context: Context,
        username: String, password: String
    ) {
        val sha = context.getSharedPreferences(
            "APP",
            Context.MODE_PRIVATE
        )
        val edit = sha.edit()
        edit.putString("USERNAME", username)
        edit.putString("PASSWORD", password)
        edit.apply()
    }
    @JvmStatic
    fun getUsername(
        context: Context
    ) :String?{
        val sha = context.getSharedPreferences(
            "APP",
            Context.MODE_PRIVATE
        )
        return sha.getString("USERNAME",null)
    }
    @JvmStatic
    fun getPassword(
        context: Context
    ) :String?{
        val sha = context.getSharedPreferences(
            "APP",
            Context.MODE_PRIVATE
        )
        return sha.getString("PASSWORD",null)
    }
}