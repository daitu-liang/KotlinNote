package com.kakaxi.kotlinnote.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kakaxi.kotlinnote.R
import com.kakaxi.kotlinnote.network.Data
import com.kakaxi.kotlinnote.network.RetrofitClient
import com.kakaxi.kotlinnote.network.api.ApiService
import kotlinx.android.synthetic.main.activity_testctivity.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.await


class Testctivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testctivity)
        tv1.setText(intent.getStringExtra("userId"))
        RetrofitClient.create<ApiService>()
            .getData(1)
            .enqueue(object : retrofit2.Callback<Data> {
                override fun onFailure(call: Call<Data>, t: Throwable) {

                }

                override fun onResponse(call: Call<Data>, response: Response<Data>) {

                }
            })


    }


}