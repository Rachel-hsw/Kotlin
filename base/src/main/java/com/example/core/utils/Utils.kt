@file:JvmName("RachelUtils")//@file,其中file表示作用对象
package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplicationJava

//定义静态函数的方式1
//kt调用，就直接导包，调用方法就可以dp2px（12f）
//java需要这样调用，UtilsKt.dp2px(12f);
//如果你仔细思考下，就会发现kt调用会有很大的问题
// 比如你有一个Utils，里面一个get方法，一个Utils2,里面一个get方法.
// 如果kotlin里面到底调用get方法，到底是谁的呢
private val displayMetrics = Resources.getSystem().displayMetrics
fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

object Utils{
    fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string: String?, duration: Int) {
        Toast.makeText(BaseApplicationJava.currentApplication(), string, duration).show()
    }
}

