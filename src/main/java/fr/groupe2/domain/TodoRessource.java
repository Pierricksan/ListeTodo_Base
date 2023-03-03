package fr.groupe2.domain;

import fr.groupe2.api.DataGestion;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.sql.SQLException;

@Path("/todos")
public class TodoRessource {
    @GET
    @Produces("text/plain")
    public String hello() throws SQLException {
        return "Liste des todo à faire";
    }
}