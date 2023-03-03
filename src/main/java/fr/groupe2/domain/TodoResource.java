package fr.groupe2.domain;

import jakarta.ws.rs.*;

@Path("/todos")
public class TodoResource {
    @GET
    @Produces("text/plain")
    public String todolist() {
        return "TodoResource !";
    }
}
