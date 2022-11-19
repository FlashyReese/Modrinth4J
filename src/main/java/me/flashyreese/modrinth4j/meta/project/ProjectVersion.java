package me.flashyreese.modrinth4j.meta.project;

import java.util.List;

public class ProjectVersion {
    private final String id;
    private final String projectId;
    private final String authorId;
    private final boolean featured;
    private final String name;
    private final String versionNumber;
    private final String changelog;
    private final String changelogUrl;
    private final String datePublished;
    private final int downloads;
    private final String versionType;
    private final List<ProjectVersionFile> files;
    private final List<ProjectVersionDependency> dependencies;
    private final List<String> gameVersions;
    private final List<String> loaders;

    public ProjectVersion(String id, String projectId, String authorId, boolean featured, String name, String versionNumber, String changelog, String changelogUrl, String datePublished, int downloads, String versionType, List<ProjectVersionFile> files, List<ProjectVersionDependency> dependencies, List<String> gameVersions, List<String> loaders) {
        this.id = id;
        this.projectId = projectId;
        this.authorId = authorId;
        this.featured = featured;
        this.name = name;
        this.versionNumber = versionNumber;
        this.changelog = changelog;
        this.changelogUrl = changelogUrl;
        this.datePublished = datePublished;
        this.downloads = downloads;
        this.versionType = versionType;
        this.files = files;
        this.dependencies = dependencies;
        this.gameVersions = gameVersions;
        this.loaders = loaders;
    }

    public String getId() {
        return id;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getName() {
        return name;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getChangelog() {
        return changelog;
    }

    public String getChangelogUrl() {
        return changelogUrl;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public int getDownloads() {
        return downloads;
    }

    public String getVersionType() {
        return versionType;
    }

    public List<ProjectVersionFile> getFiles() {
        return files;
    }

    public List<ProjectVersionDependency> getDependencies() {
        return dependencies;
    }

    public List<String> getGameVersions() {
        return gameVersions;
    }

    public List<String> getLoaders() {
        return loaders;
    }
}
