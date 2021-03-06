package com.example.app.entity

/**
 * 使用data函数修饰，会自动帮我们生成很多常用方法
 * 比如copy
 */
data class User3 constructor(var username: String?, var password: String?, var code: String?) {
    constructor():this(null,null,null)
}