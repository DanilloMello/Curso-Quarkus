package infra.exceptions;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ResourceBundle;
import java.util.UUID;

@Provider
@Slf4j
public class GenericErrorMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable e) {
        String errorId = UUID.randomUUID().toString();
        log.error("errorId[{}]", errorId, e);
        String defaultMessage = ResourceBundle.getBundle("ValidationMessages").getString("System.error");
        GenericErrorMessage message = new GenericErrorMessage(defaultMessage);
        GenericErrorResponse response = new GenericErrorResponse(errorId, message);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
    }

}
