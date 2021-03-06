package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplicationJava
import com.example.core.R

/**
 * 定义静态函数的方式2
 * 使用object修饰一个类，将会创建一个单例对象
 */
object CacheUtils {
    private val context = BaseApplicationJava.currentApplication()
    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String?): String? {
        return SP.getString(key, null)
    }
}
