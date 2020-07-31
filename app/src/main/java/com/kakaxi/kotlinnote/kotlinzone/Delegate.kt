package com.kakaxi.kotlinnote.kotlinzone

import kotlin.reflect.KProperty

class Delegate {
    var propValue: Any? = null
    operator fun getValue(myClass: MyClass, prop: KProperty<*>): Any? {
        println("Delegate-operator fun getValue")
        return propValue
    }

    operator fun setValue(myClass: MyClass, prop: KProperty<*>, value: Any?) {
        println("Delegate-setValue fun setValue")
        propValue = value
    }
}