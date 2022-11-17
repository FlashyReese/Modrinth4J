package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.meta.*;

public class Test implements ProjectCallback, SearchResultCallback{
    private int offset = 0;
    private ModrinthQuery query = new ModrinthQuery()
            .query("better")
            .index(Index.RELEVANCE)
            .facet(new Facet.Builder()
                    .versions("1.16.5", "1.17.1", "1.18.2", "1.19.2")
                    .projectTypes(ProjectType.MOD)
                    .build())
            .limit(100);

    public static void main(String[] args) {
        new Test().query(0);
    }

    public void query(int offset) {
        this.query.offset(offset).asyncResults(this);
    }

    @Override
    public void onProjectHit(Project project) {
        System.out.println(project.getTitle());
    }

    @Override
    public void onProjectError(ResultError resultError) {

    }

    @Override
    public void onSearchResultHit(SearchResult searchResult) {
        if (this.offset < searchResult.getTotalHits()) {
            this.offset += 100;
            this.query(this.offset);
        }
        searchResult.getHits().forEach(searchProjectHit -> searchProjectHit.asyncProject(this));
    }

    @Override
    public void onSearchResultError(ResultError resultError) {

    }
}
