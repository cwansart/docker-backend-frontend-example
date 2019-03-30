package de.openknowledge.dockerbackendfrontendexample.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    private Long id;

    @NotNull
    private String author;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String message;

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
