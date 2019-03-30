package de.openknowledge.dockerbackendfrontendexample.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class MessageRepository {

    @PersistenceContext(unitName = "myapp")
    private EntityManager entityManager;

    public List<Message> getAll() {
        TypedQuery<Message> query = entityManager.createQuery("select m from Message m", Message.class);
        return query.getResultList();
    }
}
