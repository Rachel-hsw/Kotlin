package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private var list: List<Lesson> = ArrayList()
    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    /**
     *java中
     * static关键字标识静态内部类
     * 不加的话就是内部类，嵌套内部类是可以获得外部的引用的
     * kt中
     * 用inner标识内部类，内部类是不能使用companion object伴生对象的
     * 静态内部类反而不需要标识
     *
     * internal 表示当前模块可见。即本模块中的其他类可以访问，但是其他模块不能被访问
     * 而java中是用@hide的注解来实现这种方式的
     * Expression 'date' of type 'String?' cannot be invoked as a function. The function 'invoke()' is not found
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        internal fun onBind(lesson: Lesson) {
            //？：如果为空，给默认值
            var date = lesson.date?:"日期待定"
            setText(R.id.tv_date, date)
            setText(R.id.tv_content, lesson.content)
            val state = lesson.state
            if (state != null) {
                setText(R.id.tv_state, state.stateName())
                var colorRes = R.color.playback
                //when有返回值，想到于switch
                colorRes = when (state) {
                    //Incompatible types: Lesson.State and String?
                    Lesson.State.PLAYBACK -> {
                        // 即使在 {} 中也是需要 break 的。
                        R.color.playback
                    }
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                    //多条件逗号分隔
                    //Lesson.State.LIVE,Lesson.State.WAIT  -> R.color.live
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state)!!.setBackgroundColor(backgroundColor)
            }
        }

        companion object {
             fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }
    }
}

