package me.flashyreese.modrinth4j.meta;

public class GalleryImage {
    private final String url;
    private final boolean featured;
    private final String title;
    private final String description;
    private final String created;

    public GalleryImage(String url, boolean featured, String title, String description, String created) {
        this.url = url;
        this.featured = featured;
        this.title = title;
        this.description = description;
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }
}
