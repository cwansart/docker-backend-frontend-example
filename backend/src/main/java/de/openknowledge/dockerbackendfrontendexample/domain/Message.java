package de.openknowledge.dockerbackendfrontendexample.domain;

import java.time.LocalDateTime;

public class Message {

    private final Long id;

    private final String author;

    private final LocalDateTime date;

    private final String message;

    Message(
        final Long id,
        final String author,
        final LocalDateTime date,
        final String message
    ) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
