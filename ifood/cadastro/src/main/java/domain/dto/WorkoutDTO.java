package domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
@Data
@RegisterForReflection
public class WorkoutDTO {
    Long id;
    @Size(min = 3, max = 20)
    @NotNull(message = "Name is NULL!")
    @NotBlank(message = "Name is required!")
    String name;
    public LocalDateTime creationDate;
    public LocalDateTime updateDate;
}
