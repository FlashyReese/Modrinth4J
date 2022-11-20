package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.search.ResultError;

public interface ErrorCallback {
    default void onError(ResultError resultError) {
        System.out.println(resultError.getDescription());
    }
}
