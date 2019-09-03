package com.illichso.rest;

import com.illichso.model.entity.User;
import com.illichso.service.AccountService;
import com.illichso.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/user")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GET
    @Path("test")
    @Produces(TEXT_PLAIN)
    public String getPlain() {
        return "Hello World from User!!!";
    }

    @POST
    @Path("create")
    public Response createUser(String username) {
        User user = userService.saveUser(username);
        return Response.status(201).entity(user).build();
    }
}
