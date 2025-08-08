package me.jeryannejane.api.domain.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("Post not found");
    }
}
