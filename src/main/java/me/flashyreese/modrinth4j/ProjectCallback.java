package me.flashyreese.modrinth4j;

import me.flashyreese.modrinth4j.meta.Project;
import me.flashyreese.modrinth4j.meta.ResultError;

public interface ProjectCallback {
    void onProjectHit(Project project);

    void onProjectError(ResultError resultError);
}
