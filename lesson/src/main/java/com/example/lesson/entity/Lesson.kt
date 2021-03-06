package com.example.lesson.entity

/**
 * 构造属性：属性，可以直接在参数传递时生成
 */
class Lesson constructor(var date: String?, var content: String?, var state: State?){


//    /**
//     * 主构造器
//     */
//    init {
//        this.date = date
//        this.content = content
//        this.state = state
//    }


    /**
     * 枚举
     */
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }

}