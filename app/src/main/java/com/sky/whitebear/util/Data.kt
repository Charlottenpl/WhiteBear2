package com.sky.whitebear.util

import android.content.Context
import android.content.SharedPreferences

class Data {
    private lateinit var context : Context;
    private val DataBase : String = "WhiteBear"
    private lateinit var sp : SharedPreferences ;

    fun check(){
        if (sp == null){
            sp = context.getSharedPreferences(DataBase,Context.MODE_PRIVATE)
        }
    }

    open fun set(key:String,value:String){
        check()
        var editer = sp.edit()
        editer.putString(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Int){
        check()
        var editer = sp.edit()
        editer.putInt(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Float){
        check()
        var editer = sp.edit()
        editer.putFloat(key,value)
        editer.apply()
    }

    open fun set(key:String,value:Boolean){
        check()
        var editer = sp.edit()
        editer.putBoolean(key,value)
        editer.apply()
    }

    open fun get(key: String): String {
        return sp.getString(key, "")!!
    }

    open fun getInt(key:String): Int {
        return sp.getInt(key, 0)
    }

    open fun getFloat(key:String): Float {
        return sp.getFloat(key, 0.0F)
    }

    open fun getBoolean(key:String): Boolean {
        return sp.getBoolean(key, false)
    }
}

const val Account = "ACCOUNT"
const val UserId = "USERID"
const val InitSuccess = "INIT-SUCCESS"
const val LoginSuccess = "LOGIN-SUCCESS"