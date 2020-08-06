package com.kakaxi.kotlinnote.kotlinzone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {
    fun  getUserInfo(userId:String):LiveData<User>{
        val liveData=MutableLiveData<User>()
        liveData.value= User("kakaxi",userId,40)
        return liveData
    }
    fun  getUserInfo():LiveData<User>{
        val liveData=MutableLiveData<User>()
        liveData.value= User("kakaxi","无惨",40)
        return liveData
    }
}