package br.com.brpartners.technical.evaluation.client;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import br.com.brpartners.technical.evaluation.client.model.IbgeCityResponse;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "ibge-api")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public interface IbgeClient {

	@GET
	@Path("/localidades/estados/{uf}/municipios")
	List<IbgeCityResponse> getCitiesByUF(@PathParam("uf") String uf);

}
