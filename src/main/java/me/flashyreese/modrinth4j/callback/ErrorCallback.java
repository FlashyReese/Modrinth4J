package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.ResultError;

public interface ErrorCallback {
    default void onError(ResultError error) {
        System.out.println(error.getDescription());
    }
}
