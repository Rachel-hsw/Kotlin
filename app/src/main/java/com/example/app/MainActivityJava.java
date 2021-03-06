package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.entity.UserJava;
import com.example.app.widget.CodeViewJava;
import com.example.core.utils.CacheUtilsJava;
import com.example.core.utils.UtilsJava;
import com.example.lesson.LessonActivityJava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityJava extends AppCompatActivity
        implements View.OnClickListener {

    private final String usernameKey = "username";
    private final String passwordKey = "password";

    private EditText et_username;
    private EditText et_password;
    private EditText et_code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_code = findViewById(R.id.et_code);

        et_username.setText(CacheUtilsJava.get(usernameKey));
        et_password.setText(CacheUtilsJava.get(passwordKey));

        final Button btn_login = findViewById(R.id.btn_login);
        final CodeViewJava img_code = findViewById(R.id.code_view);
        btn_login.setOnClickListener(this);
        img_code.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof CodeViewJava) {
            CodeViewJava codeView = (CodeViewJava) v;
            codeView.updateCode();
        } else if (v instanceof Button) {
            login();
        }
    }

    private void login() {
        final String username = et_username.getText().toString();
        final String password = et_password.getText().toString();
        final String code = et_code.getText().toString();

        final UserJava user = new UserJava(username, password, code);
        if (verify(user)) {
            CacheUtilsJava.save(usernameKey, username);
            CacheUtilsJava.save(passwordKey, password);
            startActivity(new Intent(this, LessonActivityJava.class));
        }
    }

    private boolean verify(UserJava user) {
        if (user.getUsername() != null && user.getUsername().length() < 4) {
            UtilsJava.toast("用户名不合法");
            return false;
        }
        if (user.getPassword() != null && user.getPassword().length() < 4) {
            UtilsJava.toast("密码不合法");
            return false;
        }
        return true;
    }
}
