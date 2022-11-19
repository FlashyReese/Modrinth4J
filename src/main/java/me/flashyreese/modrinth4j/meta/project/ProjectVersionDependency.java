package me.flashyreese.modrinth4j.meta.project;

public class ProjectVersionDependency {
    private final String versionId;
    private final String projectId;
    private final String fileName;
    private final String dependencyType;

    public ProjectVersionDependency(String versionId, String projectId, String fileName, String dependencyType) {
        this.versionId = versionId;
        this.projectId = projectId;
        this.fileName = fileName;
        this.dependencyType = dependencyType;
    }

    public String getVersionId() {
        return versionId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDependencyType() {
        return dependencyType;
    }
}
