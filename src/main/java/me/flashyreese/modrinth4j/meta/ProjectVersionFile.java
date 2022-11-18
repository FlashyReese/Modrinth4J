package me.flashyreese.modrinth4j.meta;

import java.util.Map;

public class ProjectVersionFile {
    private final Map<String, String> hashes;
    private final String url;
    private final String filename;
    private final boolean primary;
    private final long size;

    public ProjectVersionFile(Map<String, String> hashes, String url, String filename, boolean primary, long size) {
        this.hashes = hashes;
        this.url = url;
        this.filename = filename;
        this.primary = primary;
        this.size = size;
    }

    public Map<String, String> getHashes() {
        return hashes;
    }

    public String getUrl() {
        return url;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isPrimary() {
        return primary;
    }

    public long getSize() {
        return size;
    }
}
