package me.flashyreese.modrinth4j.meta.search;

import me.flashyreese.modrinth4j.Constants;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModrinthQuery {
    private String query;
    private Facet facet;
    private Index index;
    private int offset;
    private int limit;

    public ModrinthQuery query(String query) {
        this.query = query;
        return this;
    }

    public ModrinthQuery facet(Facet facet) {
        this.facet = facet;
        return this;
    }

    public ModrinthQuery index(Index index) {
        this.index = index;
        return this;
    }

    public ModrinthQuery offset(int offset) {
        this.offset = offset;
        return this;
    }

    public ModrinthQuery limit(int limit) {
        //Todo: check 0 < limit =< 100
        this.limit = limit;
        return this;
    }

    public String getUrlQuery() {
        Map<String, String> requestParameters = new HashMap<>();
        if (this.query != null) {
            requestParameters.put("query", this.query);
        }
        if (this.facet != null) {
            requestParameters.put("facets", this.facet.toString());
        }
        if (this.index != null) {
            requestParameters.put("index", this.index.toString());
        }
        if (this.offset > 0) {
            requestParameters.put("offset", String.valueOf(this.offset));
        }
        if (this.limit > 0 && this.limit <= 100) {
            requestParameters.put("limit", String.valueOf(this.limit));
        }

        return requestParameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(requestParameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&", "https://api.modrinth.com/v2/search?", ""));
    }

    public CompletableFuture<SearchResult> queue() {
        CompletableFuture<SearchResult> searchResultCompletableFuture = new CompletableFuture<>();

        Request request = new Request.Builder()
                .url(this.getUrlQuery())
                .get()
                .addHeader("User-Agent", "github_org/modrinth4j")
                .build();
        Call call = Constants.OK_HTTP_CLIENT.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.body() == null) {
                    //searchResultCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
                    return;
                }

                String body = Objects.requireNonNull(response.body()).string();
                ResultError error = Constants.GSON.fromJson(body, ResultError.class);

                if (error.getError() != null && error.getDescription() != null) {
                    //searchResultCallback.onError(error);
                    return;
                }
                SearchResult result = Constants.GSON.fromJson(body, SearchResult.class);
                searchResultCompletableFuture.complete(result);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //searchResultCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
            }
        });

        return searchResultCompletableFuture;
    }
}
