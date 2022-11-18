package me.flashyreese.modrinth4j.callback;

import me.flashyreese.modrinth4j.meta.Project;

public interface ProjectCallback extends ErrorCallback {
    void onProjectHit(Project project);
}
