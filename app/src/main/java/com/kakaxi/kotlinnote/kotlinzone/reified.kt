package com.kakaxi.kotlinnote.kotlinzone

import android.content.Context
import android.content.Intent

/**
 * 无惨
 * inline内联函数+reified泛型实化，kotlin能够识别泛型的实际类型
 */
inline fun<reified T> startActivity(context: Context){
    val intent=Intent(context,T::class.java)
    context.startActivity(intent)
}

/**
 * 携带参数
 * 内联函数inline+高阶函数
 * startActivity内新加个函数类型参数block，且定义intent类当中Intent.，
 * 创建Intent实例后，然后调用该函数的类型参数；
 * 相当于外部
 *  startActivity<Testctivity>(this) {
 *  putExtra("userId", 12323)
 *  putExtra("name", "apple")
 *
 * }
 *
 */
inline fun<reified T> startActivity(context: Context,block:Intent.()->Unit){
    val intent=Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}
/**
 * 高阶函数：一个函数接受另一个函数作为参数，或返回值类型为另一个函数；
 * 函数类型语法：
 * (String,Int)->Unit:
 * ->左边声明函数接受的参数，多个参数逗号隔开，若无参数，一对空括号表示（）->Unit
 * ->右边声明函数返回的类型，若无返回类型使用Unit,等价java中的void
 * fun example(func:(Sting,Int)->Unit){
 * func("test",232)
 * }
 *
 */
