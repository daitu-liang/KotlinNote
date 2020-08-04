package com.kakaxi.kotlinnote.untils

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    text: String, actionText: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
){
    val snackbar=Snackbar.make(this,text,duration)
    if(actionText!=null&&block!=null){
        snackbar.setAction(actionText){
            block()
        }
    }
    snackbar.show()
}

fun View.showSnackbar(
    resId: Int, actionText: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
){
    val snackbar=Snackbar.make(this,resId,duration)
    if(actionText!=null&&block!=null){
        snackbar.setAction(actionText){
            block()
        }
    }
    snackbar.show()
}