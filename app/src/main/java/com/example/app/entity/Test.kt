package com.example.app.entity

val user=User3("AA","BB","CC")
val  userCopy= user.copy()
fun main(){
    println(user)
    println(userCopy)
    //在java中，==表示比较的是地址
    //在kotlin中，==表示equals函数。因为kotlin把这些细节隐藏了，害，这也是太简洁不好的地方
    //使用tools-->kotlin-->show kotlin bytecode我们可以看见相应的java代码
    println(user== user)
    println(Any()== user)

    println(user=== user)

}