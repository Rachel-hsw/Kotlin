package com.example.core;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolderJava extends RecyclerView.ViewHolder {
    public BaseViewHolderJava(@NonNull View itemView) {
        super(itemView);
    }

    @SuppressLint("UseSparseArrays")
    private final Map<Integer, View> viewHashMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    protected <T extends View> T getView(@IdRes int id) {
        View view = viewHashMap.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            viewHashMap.put(id, view);
        }
        return (T) view;
    }

    protected void setText(@IdRes int id, @Nullable String text) {
        ((TextView) getView(id)).setText(text);
    }
}
