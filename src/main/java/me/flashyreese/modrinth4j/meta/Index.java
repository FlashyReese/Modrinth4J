package me.flashyreese.modrinth4j.meta;

public enum Index {
    RELEVANCE("relevance"),
    DOWNLOADS("downloads"),
    FOLLOWS("follows"),
    NEWEST("newest"),
    UPDATED("updated");

    private final String name;

    Index(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
