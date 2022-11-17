package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.meta.SearchResult;
import me.flashyreese.modrinth4j.meta.ResultError;

public interface SearchResultCallback {
    void onSearchResultHit(SearchResult searchResult);

    void onSearchResultError(ResultError resultError);
}
