package com.kakaxi.kotlinnote.utils

import android.content.SharedPreferences

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {

    val edit = edit()
    edit.block()
    edit.apply()
}