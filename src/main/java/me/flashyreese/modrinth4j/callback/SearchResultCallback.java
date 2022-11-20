package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.search.SearchResult;

public interface SearchResultCallback extends ErrorCallback{
    void onSearchResult(SearchResult searchResult);
}
