package com.kakaxi.kotlinnote.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeDesViewModelFactory(private val tipNum:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeDesViewModel(tipNum) as T
    }
}