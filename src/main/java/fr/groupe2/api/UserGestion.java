package fr.groupe2.api;

import fr.groupe2.models.User;
import fr.groupe2.utils.UserDataAccess;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/user")
public class UserGestion {
    private final UserDataAccess userDataAccess;

    public UserGestion() {
        this.userDataAccess = new UserDataAccess();
    }

    @GET
    @Produces("text/plain")
    public String sayUser()  {
        return "User !";
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        User user = userDataAccess.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        userDataAccess.addOneUser(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }


    @POST
    @Path("/post2")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addUser(@FormParam("nom") String nom,
                                @FormParam("prenom") String prenom) {
        User user = new User(nom, prenom);
        userDataAccess.addOneUser(user);
        return Response.ok().entity("todo " + user.getId() + " ajoutée avec succes ! ").build();
    }

    @PUT
    @Path("/put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, User user) {
        User existingUser = userDataAccess.findById(id);
        if (existingUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        user.setId(id);
        userDataAccess.update(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        userDataAccess.delete(id);
        return Response.noContent().build();
    }
}
