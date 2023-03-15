package infra.exceptions;

import lombok.Getter;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
@Getter
public class ConstraintViolationResponse {
    private final List<ConstraintViolationMessage> violations = new ArrayList<>();

    private ConstraintViolationResponse(ConstraintViolationException exception) {
        exception.getConstraintViolations().forEach(violation -> violations.add(ConstraintViolationMessage.of(violation)));
    }

    public static ConstraintViolationResponse of(ConstraintViolationException exception) {
        return new ConstraintViolationResponse(exception);
    }
}
