package com.example.core;

import com.example.core.utils.RachelUtils;
import com.example.core.utils.Utils;

class Java {
    public static void main(String[] args) {
        int age = 18;
        final String name = "Java";
        Java java = new Java();
        //Java中调用kotlin的高级函数（直接被定义在文件中的函数）
        //通过名字=（文件名+kt的后缀），这样的方式来调用。like:UtilsKt.dp2px(12f);
        //但是这个名字我们是可以修改的，使用注解的方式@file:JvmName("RachelUtils")
        RachelUtils.dp2px(12f);
        Utils.INSTANCE.toast("message");
        //需要通过伴生对象调用
        BaseApplication.Companion.currentApplication();
        //真正的静态函数可以直接调用
        BaseApplication.currentApplication();

    }
}
