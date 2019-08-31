package com.illichso.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/account")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class AccountController {

    @GET
    @Path("test")
    public String getPlain() {
        return "Hello World from Account!!!";
    }

//    @POST
//    public String createCustomer(Customer customer) {
//        ...
//    }
}
