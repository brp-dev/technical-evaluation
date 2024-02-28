package br.com.brpartners.technical.evaluation.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import br.com.brpartners.technical.evaluation.client.IbgeClient;
import br.com.brpartners.technical.evaluation.service.AddressService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/address")
@Slf4j
@Produces(APPLICATION_JSON)
public class AddressController {

    @Inject AddressService addressService;

    @Inject
    @RestClient
    IbgeClient ibgeClient;

    @GET
    @Path("/cities/{uf}")
    public Response cities(@PathParam("uf") String uf) {
        return Response.ok(ibgeClient.getCitiesByUF(uf)).build();
    }

    @GET
    @Path("/cities/{uf}/b")
    public Response citiesStartsWith_B(@PathParam("uf") String uf) {
        addressService.getCitiesOnlyStartsWith_B(uf);
        return Response.ok().build();
    }
}
