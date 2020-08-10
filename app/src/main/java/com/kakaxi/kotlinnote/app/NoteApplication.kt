package com.kakaxi.kotlinnote.app

import android.app.Application
import android.content.Context

class NoteApplication:Application() {
    companion object{
        lateinit var  context:Context
    }
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}