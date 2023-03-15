package infra.exceptions;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;

import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
public class ConstraintViolationMessage implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Schema(description = "Path of attribute validation", required = false)
    private final String path;
    @Schema(description = "Description message about triggered validation", required = true)
    private final String message;
    private ConstraintViolationMessage(ConstraintViolation<?> violation) {
        this.message = violation.getMessage();
        this.path = Stream.of(violation.getPropertyPath().toString().split("\\.")).skip(2).collect(Collectors.joining("."));
    }
    public ConstraintViolationMessage(String path, String message) {
        this.message = message;
        this.path = path;
    }
    public static ConstraintViolationMessage of(ConstraintViolation<?> violation) {
        return new ConstraintViolationMessage(violation);
    }
    public static ConstraintViolationMessage of(String violation) {
        return new ConstraintViolationMessage(null, violation);
    }
}