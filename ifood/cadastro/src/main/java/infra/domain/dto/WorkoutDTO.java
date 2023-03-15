package infra.domain.dto;

import infra.validators.DTO;
import infra.validators.ValidDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
@Data
@RegisterForReflection
@ValidDTO
public class WorkoutDTO implements DTO {
    Long id;
    @Size(min = 3, max = 20)
    @NotNull(message = "{Workout.name.notnull}")
    @NotBlank(message = "{Workout.name.blank}")
    String name;
    public LocalDateTime creationDate;
    public LocalDateTime updateDate;

    @Override
    public boolean isValid(ConstraintValidatorContext constraintValidatorContext) {
        return DTO.super.isValid(constraintValidatorContext);
    }
}
