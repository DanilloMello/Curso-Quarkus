package exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.logging.ErrorManager;

@Getter
@EqualsAndHashCode
public class ErrorResponse{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorId;

//    public ErrorResponse(String errorId, ErrorMessage errorMessage) {
//        this.errorId = errorId;
//        this.errors = List.of((err))
//    }
}
