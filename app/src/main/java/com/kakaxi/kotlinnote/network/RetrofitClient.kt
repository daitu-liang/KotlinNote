package com.kakaxi.kotlinnote.network

import com.kakaxi.kotlinnote.network.config.HttpConifg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitClient {
    inline fun <reified T> create(): T = Retrofit.Builder()
//              .client(OkHttpUtils.getClient())
        .baseUrl(HttpConifg.HTTP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
//              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(T::class.java)


}