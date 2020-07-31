package com.kakaxi.kotlinnote.kotlinzone

/**
 * key to value   to 是通过infix语法糖实现；
 * infix：函数允许我们的函数的小数点、括号等计算相关的语法去掉，看起来更加具有可读性；、
 * 要求：
 * 1、不能定义成顶层函数，它必须是某个类的成员函数，
 * 可以使用扩展函数的方式将它定义到某个类当中；
 * 2、infx函数只能且接受一个参数，至于参数类型没有限制；
 *
 * val list= listOf("kk" to 1,"pp" to 2)
 * if("test infix" beginWith "test"){
 * }
 * 等价
 *     if("test infix".startsWith("test") ){
 *     }
 */
infix fun String.beginWith(ele:String)=startsWith(ele)


infix fun <T>Collection<T>.has(element: T)=contains(element)