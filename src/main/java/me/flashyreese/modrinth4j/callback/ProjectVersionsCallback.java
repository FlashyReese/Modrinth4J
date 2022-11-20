package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.project.ProjectVersion;

import java.util.List;

public interface ProjectVersionsCallback extends ErrorCallback {
    void onProjectVersions(List<ProjectVersion> projectVersionList);
}
