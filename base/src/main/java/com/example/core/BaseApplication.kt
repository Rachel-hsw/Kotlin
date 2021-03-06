package com.example.core

import android.app.Application
import android.content.Context

/**
 * 为什么去除了Static，因为用static修饰以后，就不属于任何对象了
 * 显然，这不符合万物皆对象的概念
 */
class BaseApplication : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        currentApplication = this
    }

    /**
     * 定义静态函数的方式3
     * 伴生对象
     */
    companion object {
        //不想让外部替换值
        lateinit var currentApplication: Context
//            private set

        //因为kotlin的var会帮我们自动生成get set，所以下面这个方法可以直接省略
        /**
         * 真正的静态函数
         */
        @JvmStatic
        fun currentApplication(): Context {
            return currentApplication
        }
    }
}