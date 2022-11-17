package me.flashyreese.modrinth4j.meta;

import java.util.List;

public class Project {
    private final String id;
    private final String slug;
    private final String projectType;
    private final String team;
    private final String title;
    private final String description;
    private final String body;
    private final String bodyUrl;
    private final String published;
    private final String updated;
    private final String approved;
    private final String status;
    private final ModeratorMessage moderatorMessage;
    private final License license;
    private final String clientSide;
    private final String serverSide;
    private final int downloads;
    private final int followers;
    private final List<String> categories;
    private final List<String> additionalCategories;
    private final List<String> versions;
    private final String iconUrl;
    private final String issuesUrl;
    private final String wikiUrl;
    private final List<Donation> donationUrls;
    private final List<GalleryImage> gallery;

    private Project(String id, String slug, String projectType, String team, String title, String description, String body, String bodyUrl, String published, String updated, String approved, String status, ModeratorMessage moderatorMessage, License license, String clientSide, String serverSide, int downloads, int followers, List<String> categories, List<String> additionalCategories, List<String> versions, String iconUrl, String issuesUrl, String wikiUrl, List<Donation> donationUrls, List<GalleryImage> gallery) {
        this.id = id;
        this.slug = slug;
        this.projectType = projectType;
        this.team = team;
        this.title = title;
        this.description = description;
        this.body = body;
        this.bodyUrl = bodyUrl;
        this.published = published;
        this.updated = updated;
        this.approved = approved;
        this.status = status;
        this.moderatorMessage = moderatorMessage;
        this.license = license;
        this.clientSide = clientSide;
        this.serverSide = serverSide;
        this.downloads = downloads;
        this.followers = followers;
        this.categories = categories;
        this.additionalCategories = additionalCategories;
        this.versions = versions;
        this.iconUrl = iconUrl;
        this.issuesUrl = issuesUrl;
        this.wikiUrl = wikiUrl;
        this.donationUrls = donationUrls;
        this.gallery = gallery;
    }

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getTeam() {
        return team;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public String getBodyUrl() {
        return bodyUrl;
    }

    public String getPublished() {
        return published;
    }

    public String getUpdated() {
        return updated;
    }

    public String getApproved() {
        return approved;
    }

    public String getStatus() {
        return status;
    }

    public ModeratorMessage getModeratorMessage() {
        return moderatorMessage;
    }

    public License getLicense() {
        return license;
    }

    public String getClientSide() {
        return clientSide;
    }

    public String getServerSide() {
        return serverSide;
    }

    public int getDownloads() {
        return downloads;
    }

    public int getFollowers() {
        return followers;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getAdditionalCategories() {
        return additionalCategories;
    }

    public List<String> getVersions() {
        return versions;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public List<Donation> getDonationUrls() {
        return donationUrls;
    }

    public List<GalleryImage> getGallery() {
        return gallery;
    }
}
