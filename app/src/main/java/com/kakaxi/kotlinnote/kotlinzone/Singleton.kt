package com.kakaxi.kotlinnote.kotlinzone

/**
 * @JvmStatic 只能用在单列类或companion object中的方法，、
 * 若是加在普通方法，会报错提示，kotlin编译器会将其方法编译成真正的静态方法
 */
object Singleton {
    @JvmStatic
    fun onlydo(){
        println("object修饰类名，代表单例")
    }

}