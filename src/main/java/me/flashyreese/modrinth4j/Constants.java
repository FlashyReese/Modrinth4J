package me.flashyreese.modrinth4j;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public final class Constants {
    public static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().readTimeout(2, TimeUnit.SECONDS).build();
}
