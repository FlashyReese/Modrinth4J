package me.flashyreese.modrinth4j.meta.project;

import me.flashyreese.modrinth4j.Constants;
import me.flashyreese.modrinth4j.meta.search.ResultError;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

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

    public Map<String, CompletableFuture<ProjectVersion>> queue() {
        Map<String, CompletableFuture<ProjectVersion>> stringCompletableFutureMap = new HashMap<>();

        this.versions.forEach(version -> {

            CompletableFuture<ProjectVersion> projectVersionCompletableFuture = new CompletableFuture<>();
            String urlString = "https://api.modrinth.com/v2/version/" + version;

            Request request = new Request.Builder()
                    .url(urlString)
                    .get()
                    .addHeader("User-Agent", "github_org/modrinth4j")
                    .build();
            Call call = Constants.OK_HTTP_CLIENT.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.body() == null) {
                        //projectVersionCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
                        return;
                    }

                    String body = Objects.requireNonNull(response.body()).string();
                    ResultError error = Constants.GSON.fromJson(body, ResultError.class);

                    if (error.getError() != null && error.getDescription() != null) {
                        //projectVersionCallback.onError(error);
                        return;
                    }

                    ProjectVersion result = Constants.GSON.fromJson(body, ProjectVersion.class);
                    projectVersionCompletableFuture.complete(result);
                }

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    //projectVersionCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
                }
            });
            stringCompletableFutureMap.put(version, projectVersionCompletableFuture);
        });

        return stringCompletableFutureMap;
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
