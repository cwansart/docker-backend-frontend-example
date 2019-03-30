package de.openknowledge.dockerbackendfrontendexample.application;

import de.openknowledge.dockerbackendfrontendexample.domain.MessageRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("messages")
public class MessageResource {

    @Inject
    private MessageRepository repository;

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(repository.getAll()).build();
    }

}
