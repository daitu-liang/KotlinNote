package com.kakaxi.kotlinnote.kotlinzone

open class Person(val name:String="卡卡西",val age:Int) {
    fun  getDes(){
        println("name="+name+"age="+age)
    }
    init {
        println("Person--name-="+name+"-name")
    }
    fun  getTip(){
        println("------------------------name=$name agetip=$age")
    }

}