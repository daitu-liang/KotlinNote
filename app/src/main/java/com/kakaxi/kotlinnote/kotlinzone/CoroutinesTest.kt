package com.kakaxi.kotlinnote.kotlinzone

import com.kakaxi.kotlinnote.network.RetrofitClient
import com.kakaxi.kotlinnote.network.api.ApiService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


fun main(){

    /**
     * delay()函数非阻塞式的挂起函数，只会挂起当前协程，不会影响其他协程运行
     *
     * Thread.sleep(1000)是阻塞性的，会阻塞当前线程，运行在该线程下的所有协程都会被阻塞；
     *
     * delay（）只能在协程的作用域中或其他挂起函数中调用
     *
     * launch用来创建多个协程,无返返回值
     *
     * async必须在协程函数作用域中才能调用 ，创建的一个新的子协程，并返回Deferred对象
     * 执行Deferred对象的await()可获取返回值
      */

/*   val job= GlobalScope.launch {
        print("ddddd")
        delay(2000)
        print("eeeeeeeee")
    }
    Thread.sleep(1000)
    job.cancel()*/
/*    runBlocking {
        launch {
          println("3333")
            delay(2000)
            println("44444")
        }
        launch {
            println("rrrr")
            delay(2000)
            println("wwwww")
        }

    }*/

/*    val startTime=System.currentTimeMillis()
    runBlocking {
        repeat(100000){
            launch {
                println("嗨起来")
            }
        }
    }
    val endTime=System.currentTimeMillis()
    println(endTime-startTime)*/

/*
    runBlocking {
        coroutineScope {
            launch {
                for(i in 0 ..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope-over")

    }
    println("runBlocking-over")*/


/*    val job= Job()
    val cs=CoroutineScope(job)
    cs.launch {
        println("I  come  here!")
        delay(1000)

    }
    cs.launch {
        println("I  come  here too!")
        delay(1000)
    }
    job.cancel()*/


/*
    runBlocking {
        val resu=async {
            232+8
        }.await()
        println("await--->$resu")
    }

    //withContext可以简化asyn 同时必须指定线程
    runBlocking {
        val res= withContext(Dispatchers.Default){
            7+9
        }
        println("----->$res")
    }
*/
  runBlocking {
      getNetData()
  }
}
private suspend fun getNetData() {
    try {
        val res= RetrofitClient.create<ApiService>().getData(2).await()
        println(res)
        // 对服务器响应的数据进行处理
    }catch (e:Exception){
        // 对异常情况进行处理
        e.printStackTrace()
    }

}
/**
 *
 *  suspend关键字能将一个函数声明为一个挂起函数，但是没有协程作用域
 *
 */
 suspend fun printTest() {
    delay(1000)
/*    launch {//报错：因为没在协程作用域里，suspend并不提供协程作用域
        println("rrrr")
    }*/
}

/**
 *
 */
suspend fun printTest2()= coroutineScope {
    launch {
        println("---------->coroutineScope")
        delay(1000)
    }
}

suspend fun <T> Call<T>.await():T{
    return suspendCoroutine { continuation ->
        enqueue(object :Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
               val body=response.body()
                if(body!=null){
                    continuation.resume(body)
                }else{
                    continuation.resumeWithException(RuntimeException("response body is null"))
                }
            }
        })
    }
}