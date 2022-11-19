package me.flashyreese.modrinth4j.meta.search;

import java.util.List;

public class SearchResult {
    private final List<SearchProjectHit> hits;
    private final int offset;
    private final int limit;
    private final int totalHits;

    public SearchResult(List<SearchProjectHit> hits, int offset, int limit, int totalHits) {
        this.hits = hits;
        this.offset = offset;
        this.limit = limit;
        this.totalHits = totalHits;
    }

    public List<SearchProjectHit> getHits() {
        return hits;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalHits() {
        return totalHits;
    }
}
