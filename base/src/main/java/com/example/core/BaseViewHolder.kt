package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * ViewHolder是一个类，但是并没有像其他类一样后面带了括号
 * 是因为他主动生成了构造器
 *
 * 另外在kt中，默认一个class是被final修饰的
 * 阻止方法被重写，类被继承
 *
 * 只有abstract、open、override等关键字修饰才可以被继承
 */
abstract class BaseViewHolder: RecyclerView.ViewHolder {
    constructor(itemView: View):super(itemView)
    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View?> = HashMap()
    protected open fun <T : View?> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T?
    }

    protected open fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}



