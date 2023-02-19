package dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.util.List;
@Data
@RegisterForReflection
public class WorkoutDTO {
    String nome;
    List<ExerciseDTO> exercises;
}
