package br.com.brpartners.technical.evaluation.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import br.com.brpartners.technical.evaluation.client.IbgeClient;
import br.com.brpartners.technical.evaluation.service.BankAccountService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bank")
@Slf4j
@Produces(APPLICATION_JSON)
public class BankAccountController {

    @Inject
    BankAccountService bankAccountService;

    @GET
    @Path("/account-digit/{accountNumber}")
    public Response getAccountWithDigit(@PathParam("accountNumber") String accountNumber) {
        return Response.ok(bankAccountService.getAccountWithDigit(accountNumber)).build();
    }
}
