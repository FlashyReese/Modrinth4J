package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.meta.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ModrinthQuery query = new ModrinthQuery()
                .query("netherite")
                .index(Index.RELEVANCE)
                .facet(new Facet.Builder()
                        .versions("1.16.5", "1.17.1", "1.18.2", "1.19.2")
                        .projectTypes(ProjectType.MOD)
                        .build())
                .limit(100);

        long start = System.currentTimeMillis();
        List<Project> projectList = query.results().getHits().stream().parallel().map(SearchProjectHit::getProject).toList();
        System.out.println(System.currentTimeMillis() - start);
        projectList.forEach(project -> System.out.println(project.getTitle()));
    }
}
