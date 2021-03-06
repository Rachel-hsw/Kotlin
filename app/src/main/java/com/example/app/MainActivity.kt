package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

//继承类用：，继承接口也用：
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey = "username"
    private val passwordKey = "password"
    //et_username:EditText 直接这样声明，表示控件是不可空类型，来自空安全设计。
    //也就是说et_username:EditText =null是不会被允许的
    //可以这样定义et_username:EditText?=null 表示为可控类型
    //Java中也是有这样的应用的，比如@Nullable和@NoneNull注解方案。
    //Java中的方案和Kotlin区别，1、java中只会warn提醒，编译还是会通过的。
    //2、java中注解写起来很麻烦

    //kotlin中的tv?.setText("")=Java中的if(tv!=null){tv.setText("");}


    //lateinit延迟赋值，暗示，使用之前一定会初始化。主要应用于比如EditText无法在一开始就赋值的实例
    //因为它是在运行过程中findViewById赋值的
    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        //tv!!.setText() 强行调用
        //tv？.setText() 安全调用
        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))


        //Local variable name'btn_login' should not contain underscores
        val btn_login = findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)
        //快捷键操作 findViewById<Button>(R.id.btn_login).val
        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //Java的instanceof=kotlin的is
        //强转用as,val codeView=v as CodeView
        //当然这里没有像一样强转，是因为kotlin的智能转换
        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
        // et_username.text.toString()省略了get,实际上调用的还是getText方法
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password, code)
        //看这里看这里，太他妈神奇了，kotlin允许函数嵌套，嵌套的方法是不会被其他外部方法调用的
        //但是他是可以直接获取自己的外部方法的成员变量的，也就是说它的参数user其实不传也可以，因为它可以获取到
        fun verify(user: User): Boolean {
            //直接user.username.length报错是因为，他担心多线程情况，刚判断不为null，就被其它线程强制修改为null
            //所以这里我们可以强制调用
            //user.username?.length:0<4等价于user.username != null && user.username!!.length < 4
            if (user.username?.length ?: 0 < 4) {
                Utils.toast("用户名不合法")
                return false
            }
            if (user.password != null && user.password!!.length < 4) {
                Utils.toast("密码不合法")
                return false
            }
            return true
        }
        if (verify(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            //kotlin获取class对象LessonActivity::class，这样就可以获取到kotlin的class对象
            //但是如果LessonActivity是java类，那么获取java的对象，还需要LessonActivity::class.java
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }


}