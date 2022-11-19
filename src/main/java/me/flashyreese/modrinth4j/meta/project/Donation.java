package me.flashyreese.modrinth4j.meta.project;

public class Donation {
    private final String id;
    private final String platform;
    private final String url;

    public Donation(String id, String platform, String url) {
        this.id = id;
        this.platform = platform;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }

    public String getUrl() {
        return url;
    }
}
