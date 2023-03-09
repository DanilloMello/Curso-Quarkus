package exception;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Slf4j
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        Response response;
        if (throwable instanceof WebApplicationException) {
            response = ((WebApplicationException) throwable).getResponse();
            return Response.fromResponse(response).entity(throwable.getMessage()).build();
        }
        log.error(throwable.getMessage(), throwable.getCause());
        return Response.serverError().entity("#ERROR# " + "Class: " + throwable.getStackTrace()[0].getClassName() + " - Method: " + throwable.getStackTrace()[0].getMethodName()
        ).build();
    }

}



