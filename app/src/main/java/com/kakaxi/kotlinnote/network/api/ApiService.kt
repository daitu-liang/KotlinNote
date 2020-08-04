package com.kakaxi.kotlinnote.network.api

import com.kakaxi.kotlinnote.network.Data
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //类型1  get: http:xxxxx/getData.json
    @GET("{page}/getData.json")
    fun getData(@Path("page") page: Int): Call<Data>

    //类型2  get: http:xxxxx/getData.json？userName=<name>&token=<token>
    @GET("getData.json")
    fun getData(@Query("userName") userName: String, @Query("token") token: String): Call<Data>

    //类型3  get: http:xxxxx/data/<id>
    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    //类型4  get: http:xxxxx/data/create
    @POST("data/create")
    fun creatUser(@Body data: Data): Call<ResponseBody>
}