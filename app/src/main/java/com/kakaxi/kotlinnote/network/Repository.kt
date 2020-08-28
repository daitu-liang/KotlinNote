package com.kakaxi.kotlinnote.network

import android.util.Log.i
import androidx.lifecycle.liveData
import com.kakaxi.kotlinnote.model.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

/**
 * 仓库层
 * liveData将异步获取的数据以响应式编程方式通知上层
 * 通过本地存储数据或网络数据NetworkManage.kt
 *
 */
object Repository {
/*    fun goLogin(name:String,pwd:String)= liveData(Dispatcher.IO){
        val result=try {
            val userInfo=NetworkManage.getUserInfo(name,pwd)
            if(userInfo.code==200){
                Result.success(userInfo)
            }else{
                Result.failure(RuntimeException("resopnse statue is $userInfo.code"))
            }
        }catch (e:Exception){
            Result.failure<UserInfo>(e)
        }
        emit(result)//类似调用LiveData对象的setValue()通知数据变化
    }*/

    //简化
    fun goLogin(name:String,pwd:String)= fire(Dispatchers.IO){
        val userInfo=NetworkManage.getUserInfo(name,pwd)
        if(userInfo.code==200){
            Result.success(userInfo)
        }else{
            Result.failure(RuntimeException("resopnse statue is $userInfo.code"))
        }
    }

    //将异常捕获提取出来统一处理
    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}