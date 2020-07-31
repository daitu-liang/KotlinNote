package com.kakaxi.kotlinnote.kotlinzone

import kotlin.math.max

fun main() {
//------------------infix函数----------------------------------------
    //infix,创建infix.kt文件定义infix函数
    val list = listOf("kk" to 1, "pp" to 2)
    if (list.contains("2")) {

    }
    //infix写法
    if (list has 2) {

    }

    if ("2jjj".startsWith("2")){

    }
    //infix写法
    if ("2jjj" beginWith "2"){

    }

//----------------------------------------------------------

//    val name:String="卡卡西",val age:Int
//        var p=Person(name="Mingren" ,age=92) //省略new
//        var p=Person(age=92) //省略new
        //  doPush(p)

/*
    val setlist = listOf("ddddd", "af9898989jihuhdf", "frrp", "erdfvdfdssu")
    val maxlength = setlist.maxBy { it.length }
//    println("maxlength---->"+maxlength)
    val newList = setlist.map { it.toUpperCase() }
    val tlist = setlist.filter { it.length > 6 }.map { it.toUpperCase() }
    for (child in tlist) {
        println("newList---->" + child)
    }
*/


/*    val map= HashMap<String,Int>()
    map["aa"]=1
    map["bb"]=2
    map["cc"]=3
    val map1= mapOf("kk" to 1,"pp" to 2)//不可变

    val map2= mutableMapOf("kk" to 1,"pp" to 2)//可变
    map2["cc"]=3
   for ((des,index) in map2){
       println(des+"---->"+index)
   }*/

        /*  val setlist= setOf("d","a","p","u")//set集合和list集合用法一样
      val muset= mutableListOf("d","a","p","u")
      muset.add("分数线")

      val mlist= listOf("d","a","p","u")//listOf 不能添加删除 修改集合，是不可变集合
      val mutable= mutableListOf("d1","a2","p3","u4")//mutableListOf可变集合，
      mutable.add("kakaxi")
      mutable.add(5,"22")
      mutable.add(6,"66")

      for (chid in muset) println(chid)*/


        /*   Singleton.onlydo()
       Singleton.onlydo()*/


/*    val car=CarInfo("比亚迪汉",27.8)
    val car2=CarInfo("比亚迪汉",27.8)
    car.hashCode()
    println("car.hashCode()="+car.hashCode())
    println("car.toString()="+car.toString())
    println("-------------------")

    println("car2.hashCode()="+car2.hashCode())
    println("car2.toString()="+car2.toString())
    println("car2.equals(car)="+car2.equals(car))*/


//    var p=Person("kakaxi",88)//省略new
//    p.getDes()

//    var s=Student("nun002","kkaxi",89)
//    s.getDes()
//    s.costMoney()
//    s.runWay()
//    s.puhshi()


/*    println("checkNumByName-------> a=" + checkNumByName("k"))
    var a = "1"
    a = "99"
    println("kakakka-------> a=" + getScore("la"))
    println("kakakka-------> large=" + getLargeNum(43, 60))
    checkNum(11L)
    //for-in里  ：  ".."=双端闭区间；0 until 10 左闭右开  step num；downTo降序排列遍历
//    for (i in 10 downTo  0 step 3) println(i)
    var n = 0
    while(n<4) println(++n)*/

}
fun checkNumByName(name: String) = when {
    name.startsWith("k") -> 534
    name == "ka" -> 44
    name == "la" -> 55
    else -> 1212
}


fun checkNum(num: Number) {
    when (num) {
        is Int -> println("int")
        is Double -> println("double")
        else -> println("noting")

    }
}

/*fun getScore(name: String) :Int {
    return when (name) {
        "ka" -> 990
        "la" -> 88
        "ja" -> 77
        else -> 11
    }
}*/
fun getScore(name: String) = when (name) {
    "ka" -> 990
    "la" -> {
        88 + 66
    }
    "ja" -> 77
    else -> 11
}


//--------------------------
/*fun getLargeNum(old:Int,new :Int) :Int{
    return max(old,new)
}*/

fun getLargeNum(old: Int, new: Int) = max(old, new)


//var person:Person?=null
const val LOG_TAG="顶层作用域静态常量获取"
fun doPush(person: Person?) {
    if (person != null) {
        person.getDes()
        person.getTip()
        println("jkkkkkk${"iiiiii"}")
    }

    person?.let { p->
        p.getDes()
        p.getTip()
    }

    person?.let {
        it.getTip()
        it.getDes()
    }
}