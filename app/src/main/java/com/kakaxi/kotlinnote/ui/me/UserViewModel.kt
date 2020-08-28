package com.kakaxi.kotlinnote.ui.me

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kakaxi.kotlinnote.kotlinzone.User
import com.kakaxi.kotlinnote.model.UserInfo
import com.kakaxi.kotlinnote.network.Repository
import com.kakaxi.kotlinnote.ui.user.ui.login.LoggedInUserView

class UserViewModel:ViewModel() {
    private val tranUserLiveData = MutableLiveData<LoggedInUserView>()
    val userLivaData=Transformations.switchMap(tranUserLiveData){
      it->Repository.goLogin(it.displayName,it.displayName)
    }
    fun getUserInfo(name:String){
        tranUserLiveData.value=LoggedInUserView(name)
    }
}