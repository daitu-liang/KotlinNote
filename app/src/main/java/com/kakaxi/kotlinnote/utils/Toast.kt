package com.kakaxi.kotlinnote.utils

import android.content.Context
import android.widget.Toast
import com.kakaxi.kotlinnote.app.NoteApplication
import java.time.Duration

/**
 * toast工具
 * 默认显示LENGTH_SHORT，可从调用时设置
 * string 传字符串
 * Int 资源文件内容string.xml
 */

fun String.showToast(duration: Int=Toast.LENGTH_SHORT){
    Toast.makeText(NoteApplication.context,this,duration).show()
}

fun Int.showToast(duration: Int=Toast.LENGTH_SHORT){
    Toast.makeText(NoteApplication.context,this,duration).show()
}
