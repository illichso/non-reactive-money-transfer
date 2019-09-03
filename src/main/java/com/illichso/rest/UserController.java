package com.illichso.rest;

import com.illichso.model.entity.User;
import com.illichso.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.status;

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
        return status(Response.Status.CREATED).entity(user).build();
    }

    @GET
    @Path("all")
    public Response getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return status(Response.Status.OK).entity(allUsers).build();
    }
}
