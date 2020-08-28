package com.kakaxi.kotlinnote.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kakaxi.kotlinnote.R
import com.kakaxi.kotlinnote.adapter.FunAdapter
import com.kakaxi.kotlinnote.network.Data
import com.kakaxi.kotlinnote.network.RetrofitClient
import com.kakaxi.kotlinnote.network.api.ApiService
import kotlinx.android.synthetic.main.activity_testctivity.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.await
import java.util.ArrayList

// RetrofitClient.create(ApiService::class.java)
class Testctivity : AppCompatActivity() {
    private lateinit var mAdapter: FunAdapter
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

        val mlist=ArrayList<String>()
        for (i in 0..50){
            mlist.add("fun描述---》$i")
        }
        rv.layoutManager=LinearLayoutManager(this)
        if(!::mAdapter.isInitialized){
            mAdapter=FunAdapter(this,mlist)
        }
        rv.adapter=mAdapter

        var num=Int.MIN_VALUE
    }


}