package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.SearchResult;

public interface SearchResultCallback extends ErrorCallback {
    void onSearchResultHit(SearchResult searchResult);
}
