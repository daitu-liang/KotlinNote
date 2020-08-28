package com.kakaxi.kotlinnote.model

data class UserInfo(
    val realName: String,
    val token: String
) : BaseResponse()