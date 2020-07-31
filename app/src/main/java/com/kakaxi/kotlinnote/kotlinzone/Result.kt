package com.kakaxi.kotlinnote.kotlinzone

import java.lang.Exception

/**
 * 密封类  sealed class；不需要else
 */
sealed class Result{
    class Success(val msg: String) : Result()
    class Failure(val error: Exception) : Result()

    fun getResul(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> "报错：$result.error.message"
    }
}
/*
interface Result {
    class Success(val msg: String) : Result
    class Failure(val error: Exception) : Result

    fun getResul(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> result.error.message
        else -> throw IllegalArgumentException()
    }
}*/
