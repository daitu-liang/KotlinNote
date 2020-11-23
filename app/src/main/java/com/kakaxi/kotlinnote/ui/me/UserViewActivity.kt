package com.kakaxi.kotlinnote.ui.me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kakaxi.kotlinnote.R
import com.kakaxi.kotlinnote.base.BaseActivity
import kotlinx.android.synthetic.main.activity_user_view.*

class UserViewActivity : BaseActivity() {
    val userWiewModel by lazy { ViewModelProvider(this).get(UserViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_view)

        userWiewModel.userLivaData.observe(this, Observer {  userinfo->
            //获取网络响应结果
          val user=userinfo.getOrNull()
            if(user!=null){
                textView.text=user.realName
            }
        })
    }

}