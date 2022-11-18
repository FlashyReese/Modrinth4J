package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.callback.ProjectCallback;
import me.flashyreese.modrinth4j.callback.ProjectVersionCallback;
import me.flashyreese.modrinth4j.callback.SearchResultCallback;
import me.flashyreese.modrinth4j.meta.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test implements ProjectCallback, SearchResultCallback, ProjectVersionCallback {
    private int offset = 0;
    private final ModrinthQuery query = new ModrinthQuery()
            .query("fabulously optimized")
            .index(Index.RELEVANCE)
            .facet(new Facet.Builder()
                    .versions("1.16.5", "1.17.1", "1.18.2", "1.19.2")
                    .projectTypes(ProjectType.MOD_PACK)
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
        project.asyncVersions(this);
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
    public void onProjectVersionHit(ProjectVersion projectVersion) {
        System.out.println(projectVersion.getVersionNumber());
    }
}
