package com.example.lesson;

import com.example.core.utils.UtilsJava;
import com.example.core.http.EntityCallbackJava;
import com.example.core.http.HttpClientJava;
import com.example.lesson.entity.LessonJava;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class LessonPresenterJava {
    private static final String LESSON_PATH = "lessons";

    private LessonActivityJava activity;

    LessonPresenterJava(LessonActivityJava activity) {
        this.activity = activity;
    }

    private List<LessonJava> lessons = new ArrayList<>();

    private final Type type = new TypeToken<List<LessonJava>>() {
    }.getType();

    void fetchData() {
        HttpClientJava.INSTANCE.get(LESSON_PATH, type, new EntityCallbackJava<List<LessonJava>>() {
            @Override
            public void onSuccess(@NonNull final List<LessonJava> lessons) {
                LessonPresenterJava.this.lessons = lessons;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.showResult(lessons);
                    }
                });
            }

            @Override
            public void onFailure(@Nullable final String message) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UtilsJava.toast(message);
                    }
                });
            }
        });
    }

    void showPlayback() {
        List<LessonJava> playbackLessons = new ArrayList<>();
        for (LessonJava lesson : lessons) {
            if (lesson.getState() == LessonJava.State.PLAYBACK) {
                playbackLessons.add(lesson);
            }
        }
        activity.showResult(playbackLessons);
    }
}