package com.kakaxi.kotlinnote.kotlinzone

import android.os.Parcel
import android.os.Parcelable

/**
 * 扩展函数
 *创建String.kt，文件名没有固定要求，建议和添加扩展函数类名一致，方便查看
 * 最好定义为顶层方法，全局可访问
 * 语法结构：
 * fun ClassName.methodName(params1:Int,params2:String):Int{ retun 0}
 *
 */
fun String.lettersCount():Int{
    var count =0
    for (char in this){
        if(char.isLetter()){
            count++
        }
    }
    return count
}

//运算符重载  "apple"*4  = appleappleappleapple
operator  fun String.times(n:Int):String{
    val str=StringBuilder()
    repeat(n){
        str.append(this)
    }
    return str.toString()
}