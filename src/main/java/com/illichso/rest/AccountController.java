package com.illichso.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountController {

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlain() {
        return "Hello World from Account!!!";
    }
}
