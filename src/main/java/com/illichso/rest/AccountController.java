package com.illichso.rest;

import com.illichso.model.entity.Account;
import com.illichso.model.entity.User;
import com.illichso.service.AccountService;

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
    @Path("create")
    public Response createAccount(int userId) {
        Account account = accountService.saveAccount(userId);
        return status(Response.Status.CREATED).entity(account).build();
    }

    @GET
    @Path("all")
    public Response getAccounts() {
        List<User> allUsers = accountService.getAllAccounts();
        return status(Response.Status.OK).entity(allUsers).build();
    }
}
