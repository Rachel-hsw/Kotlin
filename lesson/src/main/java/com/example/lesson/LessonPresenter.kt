package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

class LessonPresenter {
    /**
     * 声明静态变量
     */
    companion object {
        /**
         * 编译器常量，这里有点不懂。val修饰不就是常量了吗，为什么还要加const
         */
        const val LESSON_PATH = "lessons"
    }

    private var activity: LessonActivity? = null

    constructor(activity: LessonActivity?) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson?>?>() {}.type
    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread(Runnable { activity!!.showResult(lessons) })
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread(Runnable { Utils.toast(message) })
            }
        })
    }

    fun showPlayback() {
        //不能用List,因为他没有set方法，是不可以修改的
        val playbackLessons: MutableList<Lesson> = ArrayList()
        //一步步化简
        for (lesson in lessons) {
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }

        lessons.forEach({ lesson: Lesson ->
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        })

        lessons.forEach(){ lesson: Lesson ->
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }

        lessons.forEach{ lesson: Lesson ->
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }

        lessons.forEach{ lesson ->
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }

        lessons.forEach{
            if (it.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(it)
            }
        }
//
//        val filter = lessons.filter { it.state === Lesson.State.PLAYBACK }
//        activity!!.showResult(filter)

        activity!!.showResult(playbackLessons)
    }
}