package com.example.core.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.core.BaseApplicationJava;
import com.example.core.R;

public class CacheUtilsJava {
    private static Context context = BaseApplicationJava.currentApplication();

    private static SharedPreferences SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    public static void save(String key, String value) {
        SP.edit().putString(key, value).apply();
    }

    public static String get(String key) {
        return SP.getString(key, null);
    }
}
