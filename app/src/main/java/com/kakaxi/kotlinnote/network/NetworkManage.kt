package com.kakaxi.kotlinnote.network

import com.kakaxi.kotlinnote.network.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 统一管理网络数据入口，对所有的API进行封装
 */
object NetworkManage {
    //    private val apiService = RetrofitClient.create(ApiService::class.java)
    //简化service
    private val apiService = RetrofitClient.create<ApiService>()
    suspend fun getUserInfo(name: String, pwd: String) = apiService.getLogin(name, pwd).await()


    /**
     * 使用协程（线程框架，协程就是launch里面的代码）简化回调的写法
     * suspend：提醒作用，告知调用者，我是一个耗时的函数，
     * 我被我的创建者用挂起的方式放到了后台运行，所以要在协程里调用“我”。
     * 它让我们的主线程不卡。通过挂起函数这种形式把耗时task切线程的这个工作交给了
     * 函数的创建者而不是调用者。调用者只会收到一个提醒：你只需要把我放在一个协程里调用。
     * suspendCoroutine
     * 挂起： 协程在执行到有supend标记的函数的时候会被挂起，挂起和开启一个协程一样，就是切个线程。
     * 只不过挂起函数在执行完毕之后协程会自动的重新切回它原先的那个线程。挂起就是一个稍后会被自动切回来的线程切换
     */
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->    //suspendCoroutine挂起当前协程
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)//调用continuation让协程恢复执行
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}