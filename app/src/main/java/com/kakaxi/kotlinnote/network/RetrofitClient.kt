package com.kakaxi.kotlinnote.network

import com.kakaxi.kotlinnote.kotlinzone.build
import com.kakaxi.kotlinnote.network.config.HttpConifg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitClient {

/*    private val retrofit = Retrofit.Builder()
        .baseUrl(HttpConifg.HTTP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)*/


    //简化

    val retrofit = Retrofit.Builder()
        .baseUrl(HttpConifg.HTTP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //inline内联函数+reified泛型实化，kotlin能够识别泛型的实际类型
    inline fun <reified T> create(): T =retrofit.create(T::class.java)



/*    //替换简化
    inline fun <reified T> create(): T = Retrofit.Builder()
//              .client(OkHttpUtils.getClient())
        .baseUrl(HttpConifg.HTTP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
//              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(T::class.java)*/
}