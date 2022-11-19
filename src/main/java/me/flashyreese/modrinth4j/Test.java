package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.meta.project.Project;
import me.flashyreese.modrinth4j.meta.project.ProjectType;
import me.flashyreese.modrinth4j.meta.project.ProjectVersion;
import me.flashyreese.modrinth4j.meta.search.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ModrinthQuery query = new ModrinthQuery()
                .query("fabulously optimized")
                .index(Index.RELEVANCE)
                .facet(new Facet.Builder()
                        .projectTypes(ProjectType.MOD_PACK)
                        .build())
                .limit(100);
        CompletableFuture<SearchResult> resultCompletableFuture = query.queue();
        for (SearchProjectHit hit : resultCompletableFuture.get().getHits()) {
            if (!hit.getTitle().equals("Fabulously Optimized"))
                return;
            System.out.println(hit.getTitle());
            Project project = hit.async().get();
            Map<String, CompletableFuture<ProjectVersion>> stringCompletableFutureMap =  project.queue();
            for (Map.Entry<String, CompletableFuture<ProjectVersion>> stringCompletableFutureEntry : stringCompletableFutureMap.entrySet()) {
                System.out.println(stringCompletableFutureEntry.getValue().get().getVersionNumber());
            }
        }
    }
}
