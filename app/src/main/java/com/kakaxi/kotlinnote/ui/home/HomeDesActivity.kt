package com.kakaxi.kotlinnote.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.edit
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.kakaxi.kotlinnote.R
import com.kakaxi.kotlinnote.base.BaseActivity
import com.kakaxi.kotlinnote.kotlinzone.*
import com.kakaxi.kotlinnote.utils.showSnackbar
import com.kakaxi.kotlinnote.utils.showToast

import kotlinx.android.synthetic.main.activity_home_des.*
import kotlin.concurrent.thread

class HomeDesActivity :  BaseActivity() , View.OnClickListener {
    //kotlin规定 companion object内定义的方法都可以采用类似Java静态方法的形式调用
    companion object {
        const val TAG = "HomeDesActivity"
        fun actionStart(context: Context, dataParams: String) {
            val intent = Intent(context, HomeDesActivity::class.java)
            intent.putExtra("params_key", dataParams)
            context.startActivity(intent)
        }

        //apply 返回调用对象，不能返回指定内容；
        // with(object){ lambda中，直接可调用object的方法，且可以返回指定内容}；
        //run: object.run{ lambda中 直接调用object方法}
        fun actionStartMutilParams(
            context: Context,
            dataParams1: String,
            dataParams2: String,
            dataParams3: String
        ) {
            val intent = Intent(context, HomeDesActivity::class.java).apply {
                putExtra("key1", dataParams1)
                putExtra("key2", dataParams2)
                putExtra("key3", dataParams3)
            }

            context.startActivity(intent)
        }
    }

    //延迟初始化lateinit
    private lateinit var person: Person
//    private lateinit var desViewModel: HomeDesViewModel
    val desViewModel by lazy { ViewModelProvider(this).get(HomeDesViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_des)
        lifecycle.addObserver(MyObserver())
//        desViewModel=ViewModelProvider(this).get(HomeDesViewModel::class.java)
//        desViewModel=ViewModelProvider(this,HomeDesViewModelFactory(40))[HomeDesViewModel::class.java]
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

        //避免重复初始化
        if (!::person.isInitialized) {
            person = Person("dd", 4)
        }
        val count = "djhkhd1233#".lettersCount()
        val count2 = "djhkhd1233#".reversed()
        val count3 = "djhkhd1233#".capitalize()
        doPush(Person("kkkkkkk", count))

        Log.i(TAG, "onCreate:reversed= $count2")

        val num1: Int = 8
        val num2: Int = 3
        var num = num1.plus(num2)
        Log.i(TAG, "onCreate: num=" + num)
        Log.i(TAG, "onCreate: num=" + num1 * 4)
        Log.i(TAG, "onCreate: num=" + "apple" * 4)
        getSharedPreferences("data", Context.MODE_PRIVATE).edit {
            putString("name", "平安经")
            putLong("userId", 2343)
        }

        button4.setOnClickListener {
            thread {//子线程必须采用postValue，否则奔溃；主线程可采用setValue
                desViewModel.addNum()
            }

        }
        button5.setOnClickListener {
           desViewModel.clearNum()
        }

        button6.setOnClickListener {
            var userId=(0..5000).random().toString()
            desViewModel.getUserInfo(userId)
        }
        desViewModel.counter.observe(this, Observer {
            it->
            et.setText(it.toString())
        })
        desViewModel.userName.observe(this, Observer {
            it->tv_des.text=it.toString()
        })

        desViewModel.userTran.observe(this, Observer {
            user->tv_des.text=user.toString()
        })

    }

    override fun onClick(v: View?) {


        when (v?.id) {
            R.id.button1 -> {
                startActivity<Testctivity>(this) {
                    putExtra("userId", 12323)
                    putExtra("name", "apple")
                }
            }


            R.id.button2 -> {
                MyClass().getP()
                val input = et.text.toString()
//                Toast.makeText(this, "button2--->${input}顶层$LOG_TAG", Toast.LENGTH_SHORT).show()
                Log.i(TAG, "exampleTest主线程: " + Thread.currentThread().name)
                "button2--->${input}顶层$LOG_TAG".showToast(Toast.LENGTH_LONG)
//                exampleTest1()
            }
            R.id.button3 -> {
//                Toast.makeText(this, "button1=$TAG", Toast.LENGTH_SHORT).show()
//                "button1=$TAG".showToast(this)
//                R.string.app_name.showToast(this)
                button1.showSnackbar("kkkaxi","点击"){
                    "显示toast".showToast()
                }

            }
        }
    }



    private fun exampleTest1() {
        thread {
            Log.i(TAG, "exampleTest2: " + Thread.currentThread().name)
        }
        Thread {
            Log.i(TAG, "exampleTest3: " + Thread.currentThread().name)
        }.start()

    }
}