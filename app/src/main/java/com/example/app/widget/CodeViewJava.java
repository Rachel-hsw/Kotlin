package com.example.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

import com.example.app.R;
import com.example.core.utils.UtilsJava;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CodeViewJava extends AppCompatTextView {

    public CodeViewJava(Context context) {
        this(context, null);
    }

    public CodeViewJava(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        setGravity(Gravity.CENTER);
        setBackgroundColor(getContext().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getColor(R.color.colorAccent));
        paint.setStrokeWidth(UtilsJava.dp2px(6f));

        updateCode();
    }

    private Paint paint = new Paint();

    private String[] codeList = new String[]{
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    };


    public void updateCode() {
        final int random = new Random().nextInt(codeList.length);
        final String code = codeList[random];
        setText(code);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0f, getHeight(), getWidth(), 0f, paint);
        super.onDraw(canvas);
    }
}
