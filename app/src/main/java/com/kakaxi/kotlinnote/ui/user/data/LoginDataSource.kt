package com.kakaxi.kotlinnote.ui.user.data

import com.kakaxi.kotlinnote.model.UserInfo
import com.kakaxi.kotlinnote.network.Data
import com.kakaxi.kotlinnote.network.RetrofitClient
import com.kakaxi.kotlinnote.network.api.ApiService
import com.kakaxi.kotlinnote.ui.user.data.model.LoggedInUser
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            val map= mapOf("userName" to username,"password" to password,
                "deviceType" to 1,"deviceNo" to "de")//不可变
            RetrofitClient.create<ApiService>()
                .getLogin(map)
                .enqueue(object : retrofit2.Callback<UserInfo> {

                    override fun onFailure(call: Call<UserInfo>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<UserInfo>, response: Response<Data>) {

                    }
                })
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}