package com.kakaxi.kotlinnote.kotlinzone

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.kakaxi.kotlinnote.ui.home.HomeDesActivity.Companion.TAG

class MyObserver :LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.i(TAG, "activityStart: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.i(TAG, "activityStop: ")
    }
}