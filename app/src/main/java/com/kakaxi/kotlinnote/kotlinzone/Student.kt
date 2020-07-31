package com.kakaxi.kotlinnote.kotlinzone

class Student(val num:String,name:String,age:Int):Person(name,age) ,Study{
    init {
        println("student---="+num+"-mm")
    }

    override fun runWay() {

        println("接口实现类runWay---name="+name+"   num="+num+"   age="+age)
    }

    override fun costMoney() {

        println("接口实现类costMoney---name="+name+"   num="+num+"   age="+age)
    }


}