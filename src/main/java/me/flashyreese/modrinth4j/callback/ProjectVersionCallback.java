package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.project.ProjectVersion;

public interface ProjectVersionCallback extends ErrorCallback {
    void onProjectVersion(ProjectVersion projectVersion);
}
