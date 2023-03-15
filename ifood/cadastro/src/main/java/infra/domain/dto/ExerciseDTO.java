package infra.domain.dto;

import infra.domain.Workout;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@RegisterForReflection
public class ExerciseDTO {
    public Long id;
    public String name;

    public Workout workout;
    public LocalDateTime creationDate;
    public LocalDateTime updateDate;
}
