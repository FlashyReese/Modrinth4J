package me.flashyreese.modrinth4j.meta;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.flashyreese.modrinth4j.Constants;
import me.flashyreese.modrinth4j.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
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

    public SearchResult results() {
        return Constants.GSON.fromJson(Utils.fetchUrlContent(this.getUrlQuery()), SearchResult.class);
    }
}
