package me.flashyreese.modrinth4j.meta;

public enum ProjectType {
    MOD("mod"),
    RESOURCE_PACK("resourcepack"),
    PLUGIN("plugin"),
    MOD_PACK("modpack");

    private final String name;

    ProjectType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
