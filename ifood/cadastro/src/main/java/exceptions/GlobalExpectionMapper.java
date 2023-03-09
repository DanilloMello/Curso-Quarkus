package exceptions;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;


@Provider
@Slf4j
public class GlobalExpectionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable e) {
        if (e instanceof ConstraintViolationException){
            List<ErrorMessage> errorMessages = ((ConstraintViolationException) e).getConstraintViolations()
                    .stream()
                    .map(cv -> new ErrorMessage(cv.getPropertyPath().toString(), cv.getMessage()))
                    .collect(Collectors.toList());
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(errorMessages)).build();
        }
        String errorId = UUID.randomUUID().toString();
        log.error("errorId[{}]", errorId, e);
        String defaultErrorMessage = ResourceBundle.getBundle("ValidationMessages").getString("System.error");
        ErrorMessage errorMessage = new ErrorMessage(defaultErrorMessage);
        ErrorResponse errorResponse = new ErrorResponse(errorId, errorMessage);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
    }
}
