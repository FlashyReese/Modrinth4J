package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.ProjectVersion;

public interface ProjectVersionCallback extends ErrorCallback {
    void onProjectVersionHit(ProjectVersion projectVersion);
}