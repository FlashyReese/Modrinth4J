package me.flashyreese.modrinth4j.meta;

public enum FacetType {
    CATEGORY("categories"),
    VERSION("versions"),
    LICENSE("license"),
    PROJECT_TYPE("project_type");

    private final String prefix;

    FacetType(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return this.prefix;
    }
}