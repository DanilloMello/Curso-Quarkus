package infra.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class GenericErrorResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorId;
    private List<GenericErrorMessage> errors;
    public GenericErrorResponse(String errorId, GenericErrorMessage errorMessage) {
        this.errorId = errorId;
        this.errors = List.of(errorMessage);
    }
    public GenericErrorResponse(GenericErrorMessage errorMessage) {
        this(null, errorMessage);
    }
    public GenericErrorResponse(List<GenericErrorMessage> errors) {
        this.errorId = null;
        this.errors = errors;
    }

    public GenericErrorResponse() {
    }
}
