package com.example.app.entity

//在java中所有类都继承自Object
//在kt中所有类都继承自Any
class User constructor(){
     var username: String? = null
    @JvmField
     var password: String? = null

    //kotlin中的get set方法是这样的，而且系统是帮我们自动写好的，我下面写的属于溶于
     var code: String? = null
        set(value) {
            field = value
        }
        get() {
            return field
        }



    //主构造器必须被调用
    constructor(username: String?, password: String?, code: String?) :this(){
        this.username = username
        this.password = password
        this.code = code
    }
}
