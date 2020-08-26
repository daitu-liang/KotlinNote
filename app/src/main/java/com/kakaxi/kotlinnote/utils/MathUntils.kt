package com.kakaxi.kotlinnote.utils

/**
 * 取最大值
 */
object MathUntils {
    fun <T:Comparable<T>>max(vararg nums:T):T{
        if(nums.isEmpty())throw RuntimeException("params can not be empty")
        var maxNum=nums[0]
        for (i in nums){
            if(i>maxNum){
                maxNum=i
            }
        }
        return maxNum
    }
}