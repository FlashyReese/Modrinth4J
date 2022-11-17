package me.flashyreese.modrinth4j.meta;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Facet {
    private final List<String> categories;
    private final List<String> versions;
    private final List<String> licenses;
    private final List<String> projectTypes;

    public Facet(List<String> categories, List<String> versions, List<String> licenses, List<String> projectTypes) {
        this.categories = categories;
        this.versions = versions;
        this.licenses = licenses;
        this.projectTypes = projectTypes;
    }

    public String toString() {
        JsonArray facets = new JsonArray();

        this.addFacet(facets, FacetType.CATEGORY, this.categories);
        this.addFacet(facets, FacetType.VERSION, this.versions);
        this.addFacet(facets, FacetType.LICENSE, this.licenses);
        this.addFacet(facets, FacetType.PROJECT_TYPE, this.projectTypes);

        return facets.toString();
    }

    private void addFacet(JsonArray facets, FacetType facetType, List<String> queries) {
        if (queries.isEmpty())
            return;

        JsonArray facet = new JsonArray();
        queries.forEach(query -> facet.add(String.format("%s:%s", facetType, query)));
        facets.add(facet);
    }

    public static class Builder {
        private final List<String> categories = new ArrayList<>();
        private final List<String> versions = new ArrayList<>();
        private final List<String> licenses = new ArrayList<>();
        private final List<String> projectTypes = new ArrayList<>();

        public Builder categories(String... categories) {
            this.categories.addAll(List.of(categories));
            return this;
        }

        public Builder versions(String... versions) {
            this.versions.addAll(List.of(versions));
            return this;
        }

        public Builder licenses(String... licenses) {
            this.licenses.addAll(List.of(licenses));
            return this;
        }

        public Builder projectTypes(String... projectTypes) {
            this.projectTypes.addAll(List.of(projectTypes));
            return this;
        }

        public Builder projectTypes(ProjectType... projectTypes) {
            this.projectTypes.addAll(Stream.of(projectTypes).map(ProjectType::toString).toList());
            return this;
        }

        public Facet build() {
            return new Facet(this.categories, this.versions, this.licenses, this.projectTypes);
        }
    }
}
