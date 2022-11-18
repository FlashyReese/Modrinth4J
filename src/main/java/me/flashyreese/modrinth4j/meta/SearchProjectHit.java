package me.flashyreese.modrinth4j.meta;

import me.flashyreese.modrinth4j.Constants;
import me.flashyreese.modrinth4j.callback.ProjectCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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

    public void asyncProject(ProjectCallback projectCallback) {
        String urlString = "https://api.modrinth.com/v2/project/" + this.projectId;

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
                    projectCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
                    return;
                }

                String body = Objects.requireNonNull(response.body()).string();
                ResultError error = Constants.GSON.fromJson(body, ResultError.class);

                if (error.getError() != null && error.getDescription() != null) {
                    projectCallback.onError(error);
                    return;
                }

                Project result = Constants.GSON.fromJson(body, Project.class);
                projectCallback.onProjectHit(result);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                projectCallback.onError(new ResultError("Response error", "Empty body")); // Todo:
            }
        });
    }
}
