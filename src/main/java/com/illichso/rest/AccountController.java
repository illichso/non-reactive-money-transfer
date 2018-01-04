package com.illichso.rest;

import com.illichso.service.AccountService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("account")
public class AccountController {

    private AccountService accountService;

    @GET
    @Path("hello")
    @Produces(APPLICATION_JSON)
    public String helloWorld() {
        return "Hello, world!";
    }
}
