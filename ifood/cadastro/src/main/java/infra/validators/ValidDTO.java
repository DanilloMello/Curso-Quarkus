package infra.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DTOValidator.class})
@Documented
public @interface ValidDTO {
    String message() default "{Constraints.default.error}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
