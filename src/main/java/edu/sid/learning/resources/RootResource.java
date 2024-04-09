package edu.sid.learning.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class RootResource {


    private final UserResource userResource;

    @Inject
    public RootResource(UserResource userResource) {
        this.userResource = userResource;
    }

    @Path("/users")
    public UserResource getUserResource() {
        return userResource;
    }
}
