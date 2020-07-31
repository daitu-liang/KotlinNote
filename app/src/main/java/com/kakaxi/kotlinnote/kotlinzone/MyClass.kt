package com.kakaxi.kotlinnote.kotlinzone



//类委托  和委托属性
class MyClass {
    var p by Delegate()
    fun getP(){
        p="--------------9999900------"
        println("MyClass------$p")
    }
}