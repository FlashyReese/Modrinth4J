package me.flashyreese.modrinth4j.meta;

import me.flashyreese.modrinth4j.Constants;
import me.flashyreese.modrinth4j.Utils;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class SearchProjectHit {
    private final String projectId;
    private final String projectType;
    private final String slug;
    private final String author;
    private final String title;
    private final String description;
    private final List<String> categories;
    private final List<String> displayCategories;
    private final List<String> versions;
    private final int downloads;
    private final int follows;
    private final String iconUrl;
    private final String dateCreated;
    private final String dateModified;
    private final String license;
    private final String clientSide;
    private final String serverSide;
    private final List<String> gallery;

    public SearchProjectHit(String projectId, String projectType, String slug, String author, String title, String description, List<String> categories, List<String> displayCategories, List<String> versions, int downloads, int follows, String iconUrl, String dateCreated, String dateModified, String license, String clientSide, String serverSide, List<String> gallery) {
        this.projectId = projectId;
        this.projectType = projectType;
        this.slug = slug;
        this.author = author;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.displayCategories = displayCategories;
        this.versions = versions;
        this.downloads = downloads;
        this.follows = follows;
        this.iconUrl = iconUrl;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.license = license;
        this.clientSide = clientSide;
        this.serverSide = serverSide;
        this.gallery = gallery;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getSlug() {
        return slug;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getDisplayCategories() {
        return displayCategories;
    }

    public List<String> getVersions() {
        return versions;
    }

    public int getDownloads() {
        return downloads;
    }

    public int getFollows() {
        return follows;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getLicense() {
        return license;
    }

    public String getClientSide() {
        return clientSide;
    }

    public String getServerSide() {
        return serverSide;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public Project getProject() {
        String result = Utils.fetchUrlContent("https://api.modrinth.com/v2/project/" + this.projectId);

        return Constants.GSON.fromJson(result, Project.class);
    }
}
