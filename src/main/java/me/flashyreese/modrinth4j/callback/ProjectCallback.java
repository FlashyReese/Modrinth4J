package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.project.Project;

public interface ProjectCallback extends ErrorCallback {
    void onProject(Project project);
}
