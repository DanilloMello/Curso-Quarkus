package infra.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DTOValidator implements ConstraintValidator<ValidDTO, DTO> {
    @Override
    public void initialize(ValidDTO constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(DTO dto, ConstraintValidatorContext context) {
        return dto.isValid(context);
    }
}
