package me.flashyreese.modrinth4j.meta;

public class ModeratorMessage {
    private final String message;
    private final String body;

    public ModeratorMessage(String message, String body) {
        this.message = message;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public String getBody() {
        return body;
    }
}
