package com.illichso.rest;

import com.illichso.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/account")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class AccountController {
    private final AccountService accountService;

    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GET
    @Path("test")
    @Produces(TEXT_PLAIN)
    public String getPlain() {
        return "Hello World from Account!!!";
    }

    @POST
    public String createAccount() {
        return "";
    }
}
