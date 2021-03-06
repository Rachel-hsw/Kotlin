package com.example.core.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface EntityCallbackJava<T> {
    void onSuccess(@NonNull T entity);

    void onFailure(@Nullable String message);
}
