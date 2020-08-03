package com.kakaxi.kotlinnote.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kakaxi.kotlinnote.R
import kotlinx.android.synthetic.main.activity_testctivity.*

class Testctivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testctivity)
        tv1.setText(intent.getStringExtra("userId"))

    }
}