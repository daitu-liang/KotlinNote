package com.kakaxi.kotlinnote.kotlinzone

import android.service.autofill.FillEventHistory

fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}