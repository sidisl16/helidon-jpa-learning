package edu.sid.learning.resources;


import edu.sid.learning.entities.User;
import edu.sid.learning.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok().entity(userService.getAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        return Response.ok(userService.add(user)).build();
    }
}