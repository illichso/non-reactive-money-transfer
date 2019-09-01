package com.illichso.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/user")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserController {

    @GET
    @Path("test")
    @Produces(TEXT_PLAIN)
    public String getPlain() {
        return "Hello World from User!!!";
    }
}
