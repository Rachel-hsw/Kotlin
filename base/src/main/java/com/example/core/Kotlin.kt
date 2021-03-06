package com.example.core

import com.example.core.utils.dp2px

//Kotlin可以直接把函数声明在文件中，而并不是一定要声明一个类
//java的void=kotlin :Unit并且可以省略
fun main(){
    print("Hello World")
    //后面的返回类型是可以省略的，因为类型推导机制
    var age:Int=18
    val name:String="Kotlin"
    //val关键字声明的属性不可更改
//    name="Android"
    age=18
    var java=Java()
    dp2px(2f)

    repeat(100){
        println(it)
    }

    val  arry= arrayOf(1,2,356,447)
//    for (i in 0 until arry.size){
//
//    }
    //arry.indices会直接返回一个区间
    for (i in arry.indices){

    }
    //实际上上面这个函数，是一个接受两个参数的方法，但是第二个参数是个lamda表达式
    //  repeat(100,{
    //    //        println(it)
    //    //    })
}

fun  doubleNumber(x:Int):Int{
    return x*2
}