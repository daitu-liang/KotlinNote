package com.kakaxi.kotlinnote.untils

import android.content.Context
import android.widget.Toast
import java.time.Duration

/**
 * toast工具
 * 默认显示LENGTH_SHORT，可从调用时设置
 * string 传字符串
 * Int 资源文件内容string.xml
 */

fun String.showToast(context: Context,duration: Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(context: Context,duration: Int=Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}