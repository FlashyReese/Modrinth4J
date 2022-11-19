package me.flashyreese.modrinth4j.meta.search;

public class ResultError {
    private final String error;
    private final String description;

    public ResultError(String error, String description) {
        this.error = error;
        this.description = description;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }
}
