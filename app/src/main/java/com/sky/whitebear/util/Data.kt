package com.sky.whitebear.util

import android.content.Context
import android.content.SharedPreferences
import com.sky.whitebear.LoginActivity

class Data {
    private val DataBase : String = "WhiteBear"

    open fun instance():SharedPreferences{
        var sp = LoginActivity.context.getSharedPreferences(DataBase,Context.MODE_PRIVATE)
        return sp
    }

    open fun set(key:String,value:String){
        var editer = instance().edit()
        editer.putString(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Int){
        var editer = instance().edit()
        editer.putInt(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Float){
        var editer = instance().edit()
        editer.putFloat(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Boolean){
        var editer = instance().edit()
        editer.putBoolean(key,value)
        editer.apply()
    }

    open fun get(key: String): String {
        return instance().getString(key, "")!!
    }

    open fun getInt(key:String): Int {
        return instance().getInt(key, 0)
    }

    open fun getFloat(key:String): Float {
        return instance().getFloat(key, 0.0F)
    }

    open fun getBoolean(key:String): Boolean {
        return instance().getBoolean(key, false)
    }
}

const val Account = "ACCOUNT"
const val UserId = "USERID"
const val InitSuccess = "INIT-SUCCESS"
const val LoginSuccess = "LOGIN-SUCCESS"