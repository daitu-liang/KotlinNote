package com.kakaxi.kotlinnote.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kakaxi.kotlinnote.kotlinzone.Repository
import com.kakaxi.kotlinnote.kotlinzone.User

class HomeDesViewModel(tipNum: Int) : ViewModel() {

    private val oldUser = MutableLiveData<User>()
    val userName: LiveData<String> = Transformations.map(oldUser) {//map转化
            user ->
        "${user.fistName} ${user.lastName}"
    }

    //有参数情况，Transformations
    private val tranUserLiveData = MutableLiveData<String>()
    val userTran: LiveData<User> = Transformations.switchMap(tranUserLiveData) {//Transformations
            userId ->
        Repository.getUserInfo(userId)
    }

    fun getUserInfo(userId: String) {
        tranUserLiveData.value = userId
    }

    //无参数情况，Transformations
    private val noParamsUserLiveData = MutableLiveData<Any?>()
    val noParamsuserTran: LiveData<User> =
        Transformations.switchMap(noParamsUserLiveData) {//Transformations
                userId ->
            Repository.getUserInfo()
        }

    fun getUserInfo() {
        tranUserLiveData.value = tranUserLiveData.value
    }

    private val _count = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = _count

    init {
        _count.value = tipNum
        oldUser.value = User("涡旋", "鸣人", 16)
    }

    fun addNum() {
        val cou = _count.value ?: 0
        _count.postValue(cou + 1)
    }

    fun clearNum() {
        _count.value = 0
    }
}