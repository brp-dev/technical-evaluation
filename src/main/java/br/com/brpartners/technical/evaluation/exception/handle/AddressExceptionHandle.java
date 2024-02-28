package br.com.brpartners.technical.evaluation.exception.handle;

import br.com.brpartners.technical.evaluation.exception.AddressException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class AddressExceptionHandle implements ExceptionMapper<AddressException> {
    @Override
    public Response toResponse(AddressException exception) {
        return Response.status(NOT_FOUND).entity(Map.of("message", exception.getMessage())).build();
    }
}
