package de.openknowledge.dockerbackendfrontendexample.domain;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class MessageRepository {

    private final List<Message> messages = Collections.unmodifiableList(Arrays.asList(
        new Message(1L, "Marie", LocalDateTime.now(), "Hey"),
        new Message(2L, "Max", LocalDateTime.now(), "Hallo"),
        new Message(3L, "Lena", LocalDateTime.now(), "Huhu"),
        new Message(4L, "Lukas", LocalDateTime.now(), "Moin")
    ));

    public List<Message> getAll() {
        return messages;
    }
}
